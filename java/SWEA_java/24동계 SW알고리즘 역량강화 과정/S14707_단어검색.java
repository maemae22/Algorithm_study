import java.util.*;
import java.io.*;

class UserSolution_S14707_단어검색 {

    static Trie[] tries;
    static int index;

    void init() {
        tries = new Trie[800000];
        index = 0;
        tries[0] = new Trie(0);
    }

    int add(char str[]) {
        int nowIndex = 0;
        for (char c : str) {
            if (Character.isAlphabetic(c)) {
                Trie now = tries[nowIndex];
                if (now.childs.containsKey(c)) {
                    nowIndex = now.childs.get(c).index;
                } else {
                    tries[++index] = new Trie(index);
                    now.childs.put(c, tries[index]);
                    nowIndex = index;
                }
            } else {
                tries[nowIndex].count++;
                break;
            }
        }

        return tries[nowIndex].count;
    }

    int remove(char str[]) {
        return findOrRemove(str, true);
    }

    int search(char str[]) {
        return findOrRemove(str, false);
    }

    public int findOrRemove(char str[], boolean remove) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        for (char c : str) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int nowIndex = q.poll();
                Trie now = tries[nowIndex];
                if (Character.isAlphabetic(c) && now.childs.containsKey(c)) {
                    q.offer(now.childs.get(c).index);
                } else if (c=='?') {
                    for (char tmp : now.childs.keySet()) {
                        q.offer(now.childs.get(tmp).index);
                    }
                } else {
                    count += now.count;
                    if (remove) {
                        now.count = 0;
                    }
                }
            }
        }

        return count;
    }
}

class Trie {
    int index;
    HashMap<Character, Trie> childs = new HashMap<>();
    int count;

    Trie(int index) {
        this.index = index;
    }
}

public class S14707_단어검색 {
    private final static int MAX_LEN = 30;
    private final static int CMD_INIT = 1;
    private final static int CMD_ADD = 2;
    private final static int CMD_REMOVE = 3;
    private final static int CMD_SEARCH = 4;

    private final static UserSolution_S14707_단어검색 usersolution = new UserSolution_S14707_단어검색();

    private static void String2Char(char[] buf, String str) {
        for (int i = 0; i < str.length(); ++i)
            buf[i] = str.charAt(i);
        buf[str.length()] = '\0';
    }

    private static boolean run(BufferedReader br) throws Exception {
        int q = Integer.parseInt(br.readLine());

        char[] str = new char[MAX_LEN + 1];
        int cmd, ans, ret = 0;
        boolean okay = false;

        for (int i = 0; i < q; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case CMD_INIT:
                    usersolution.init();
                    okay = true;
                    break;
                case CMD_ADD:
                    String2Char(str, st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.add(str);
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_REMOVE:
                    String2Char(str, st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.remove(str);
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_SEARCH:
                    String2Char(str, st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.search(str);
                    if (ret != ans)
                        okay = false;
                    break;
                default:
                    okay = false;
                    break;
            }
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("C:/Users/maema/Documents/dev/Algorithm_study/java/SWEA_java/24동계 SW알고리즘 역량강화 과정/S14707_sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}
