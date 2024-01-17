import java.util.*;

class UserSolution {

    private final static int NAME_MAXLEN	= 6;
    private final static int PATH_MAXLEN	= 1999;

    static Node[] nodes;
    static int index;
    static int haha;

    void init(int n) {
        haha = 1;
//        System.out.println(haha++ + "번째 호출");
        nodes = new Node[n*2];
        index=0;
        nodes[index++] = new Node("", 0);
//        printTree();
    }

    void cmd_mkdir(char[] path, char[] newName) {
//        System.out.println(haha++ + "번째 호출");
        int nodeNum = findNodeNumByPath(path);
        String name = String.valueOf(newName).substring(0, newName.length-1);
        nodes[nodeNum].child.put(name, index);
        nodes[index++] = new Node(name, nodeNum);
        upCountOne(index-1);
//        printTree();
    }

    int findNodeNumByPath(char[] path) {
        String name = "";
        int nodeNum = 0;

        for(int i=1; i<path.length-1; i++) {
            char c = path[i];
            if (c=='/') {
                nodeNum = nodes[nodeNum].child.get(name);
                name = "";
            } else {
                name += c;
            }
        }

        return nodeNum;
    }

    void printTree() {
        int index = 0;
        for (Node tmp : nodes) {
            System.out.println(index++ +"번째 Node는 = "+tmp);
        }
    }

    // 해당 디렉토리(me)의 부모부터 루트 디렉토리까지 count(하위 디렉토리 개수)를 하나씩 증가
    void upCountOne(int me) {
        int parent = nodes[me].parent;
        while (parent!=0) {
            nodes[parent].count++;
            parent=nodes[parent].parent;
        }
        nodes[0].count++;
    }

    void cmd_rm(char[] path) {
//        System.out.println(haha++ + "번째 호출");
        if (path.length==2) {
            nodes[0].child=new HashMap<>();
        } else {
            int nodeNum = findNodeNumByPath(path);
            downCount(nodeNum);
            nodes[nodes[nodeNum].parent].child.remove(nodes[nodeNum].name);
            nodes[nodeNum].parent=-1;
        }
//        printTree();
    }

    // 해당 디렉토리(me)의 부모부터 루트 디렉토리까지, 해당 디렉토리의 하위 디렉토리 개수+1(nodes[me].count+1)만큼 count를 감소함
    void downCount(int me) {
        int count = nodes[me].count+1;
        int parent = nodes[me].parent;
        while (parent!=0) {
            nodes[parent].count-=count;
            parent=nodes[parent].parent;
        }
        nodes[0].count-=count;
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
//        System.out.println(haha++ + "번째 호출");
        int up = findNodeNumByPath(dstPath);
        int down = findNodeNumByPath(srcPath);
        upCount(up, down);

        Node tmp = nodes[down];
        nodes[up].child.put(tmp.name, index);
        nodes[index++] = new Node(tmp.name, up, tmp.count);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{down, index-1});
        // 이전(down) 자식을 현재(index-1)의 자식으로 그대로 복사하는 과정
        while (!q.isEmpty()) {
            int[] cp = q.poll();
            for (String name : nodes[cp[0]].child.keySet()) {
                int priNum = nodes[cp[0]].child.get(name);
                nodes[cp[1]].child.put(name, index);
                nodes[index++] = new Node(name, cp[1], nodes[priNum].count);
                q.offer(new int[]{priNum, index-1});
            }
        }
//        printTree();
    }

    // 해당 디렉토리(me)부터 루트 디렉토리까지,
    // plus에 해당하는 디렉토리의 하위 디렉토리 개수+1(nodes[plus].count+1)만큼 count를 증가시켜줌
    void upCount(int me, int plus) {
        int count = nodes[plus].count+1;
        int parent = nodes[me].parent;

        nodes[me].count+=count;
        if (me!=0) {
            while (parent!=0) {
                nodes[parent].count+=count;
                parent=nodes[parent].parent;
            }
            nodes[0].count+=count;
        }
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
//        System.out.println(haha++ + "번째 호출");
        int up = findNodeNumByPath(dstPath);
        int down = findNodeNumByPath(srcPath);
        upCount(up, down);
        downCount(down);
        nodes[nodes[down].parent].child.remove(nodes[down].name);
        nodes[down].parent = up;
        nodes[up].child.put(nodes[down].name, down);
//        printTree();
    }

    int cmd_find(char[] path) {
//        System.out.println(haha++ + "번째 호출");
//        printTree();
        int nodeNum = findNodeNumByPath(path);
        return nodes[nodeNum].count;
    }
}

class Node {
    String name;
    int parent;
    int count;
    Map<String, Integer> child = new HashMap<>();

    Node(String name, int parent) {
        this.name = name;
        this.parent = parent;
    }

    Node(String name, int parent, int count) {
        this.name = name;
        this.parent = parent;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", count=" + count +
                ", child=" + child +
                '}';
    }
}

class Solution {

    private static UserSolution usersolution = new UserSolution();

    private final static int CMD_MKDIR		= 1;
    private final static int CMD_RM			= 2;
    private final static int CMD_CP			= 3;
    private final static int CMD_MV			= 4;
    private final static int CMD_FIND		= 5;

    private final static int NAME_MAXLEN	= 6;
    private final static int PATH_MAXLEN	= 1999;


    private static boolean run(Scanner sc, int m) throws Exception {

        boolean isAccepted = true;
        int cmd;
        char[] name;
        char[] path1;
        char[] path2;
        String inputStr = "";

        while (m-- > 0) {

            cmd = sc.nextInt();

            if (cmd == CMD_MKDIR) {
                inputStr = sc.next() + " ";
                path1 = inputStr.toCharArray();
                path1[inputStr.length() - 1] = '\0';
                inputStr = sc.next() + " ";
                name = inputStr.toCharArray();
                name[inputStr.length() - 1] = '\0';

                usersolution.cmd_mkdir(path1, name);
            }
            else if (cmd == CMD_RM) {
                inputStr = sc.next() + " ";
                path1 = inputStr.toCharArray();
                path1[inputStr.length() - 1] = '\0';

                usersolution.cmd_rm(path1);
            }
            else if (cmd == CMD_CP) {
                inputStr = sc.next() + " ";
                path1 = inputStr.toCharArray();
                path1[inputStr.length() - 1] = '\0';
                inputStr = sc.next() + " ";
                path2 = inputStr.toCharArray();
                path2[inputStr.length() - 1] = '\0';

                usersolution.cmd_cp(path1, path2);
            }
            else if (cmd == CMD_MV) {
                inputStr = sc.next() + " ";
                path1 = inputStr.toCharArray();
                path1[inputStr.length() - 1] = '\0';
                inputStr = sc.next() + " ";
                path2 = inputStr.toCharArray();
                path2[inputStr.length() - 1] = '\0';

                usersolution.cmd_mv(path1, path2);
            }
            else {
                int ret;
                int answer;

                inputStr = sc.next() + " ";
                path1 = inputStr.toCharArray();
                path1[inputStr.length() - 1] = '\0';

                ret = usersolution.cmd_find(path1);

                answer = sc.nextInt();

                isAccepted &= (ret == answer);
            }
        }

        return isAccepted;
    }

    public static void main(String[] args) throws Exception {
        int test, T;
        int n, m;

        // System.setIn(new java.io.FileInputStream("sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (test = 1; test <= T; ++test) {

            n = sc.nextInt();
            m = sc.nextInt();

            usersolution.init(n);

            if (run(sc, m)) {
                System.out.println("#" + test + " 100");
            }
            else {
                System.out.println("#" + test + " 0");
            }
        }

        sc.close();
    }
}
