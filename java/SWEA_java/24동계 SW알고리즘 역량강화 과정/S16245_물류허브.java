import java.util.*;
import java.io.*;

class UserSolution_S16245_물류허브 {

    static int index;
    static HashMap<Integer, Integer> convert;
    static int[][] dis;
    static int[][] disReverse;
    static ArrayList<ArrayList<City>> list;
    static ArrayList<ArrayList<City>> listReverse;

    public int init(int N, int sCity[], int eCity[], int mCost[]) {
        index = 0;
        convert = new HashMap<>();
        list = new ArrayList<>();
        listReverse = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int start = sCity[i];
            int end = eCity[i];
            if(!convert.containsKey(start)) {
                convert.put(start, ++index);
            }
            if(!convert.containsKey(end)) {
                convert.put(end, ++index);
            }
        }

        for (int i=0; i<=index; i++) {
            list.add(new ArrayList<>());
            listReverse.add(new ArrayList<>());
        }

        for (int i=0; i<N; i++) {
            int start = convert.get(sCity[i]);
            int end = convert.get(eCity[i]);
            int cost = mCost[i];
            list.get(start).add(new City(end, cost));
            listReverse.get(end).add(new City(start, cost));
        }

        dis = new int[index+1][index+1];
        disReverse = new int[index+1][index+1];

        for (int i=1; i<=index; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            Arrays.fill(disReverse[i], Integer.MAX_VALUE);
        }

        return index;
    }

    public static void dij(ArrayList<ArrayList<City>> list, int[][] dis, int main) {
        PriorityQueue<City> q = new PriorityQueue<>();
        q.offer(new City(main, 0));
        dis[main][main]=0;
        int check[] = new int[index+1];

        while (!q.isEmpty()) {
            City tmp = q.poll();
            if (tmp.cost<=dis[main][tmp.go]) {
                for (City next : list.get(tmp.go)) {
                    if (tmp.cost+next.cost<dis[main][next.go] || tmp.cost+next.cost==dis[main][next.go]&&check[next.go]==0) {
                        check[next.go]=1;
                        dis[main][next.go]=tmp.cost+next.cost;
                        q.offer(new City(next.go, dis[main][next.go]));
                    }
                }
            }
        }
    }

    public void add(int sCity, int eCity, int mCost) {
        int start = convert.get(sCity);
        int end = convert.get(eCity);
        list.get(start).add(new City(end, mCost));
        listReverse.get(end).add(new City(start, mCost));
    }

    public int cost(int mHub) {
        int hub = convert.get(mHub);
        dij(list, dis, hub);
        dij(listReverse, disReverse, hub);

        int sum = 0;
        for (int i=1; i<=index; i++) {
            sum += dis[hub][i];
            sum += disReverse[hub][i];
        }

        return sum;
    }
}

class City implements Comparable<City> {
    int go;
    int cost;
    City(int go, int cost) {
        this.go=go;
        this.cost=cost;
    }
    @Override
    public int compareTo(City o) {
        return this.cost-o.cost;
    }
}

public class S16245_물류허브 {

    private final static int MAX_N = 1400;
    private final static int CMD_INIT = 1;
    private final static int CMD_ADD = 2;
    private final static int CMD_COST = 3;

    private final static UserSolution_S16245_물류허브 usersolution = new UserSolution_S16245_물류허브();

    private static boolean run(Scanner sc) {
        int q = sc.nextInt();

        int n;
        int[] sCityArr = new int[MAX_N];
        int[] eCityArr = new int[MAX_N];
        int[] mCostArr = new int[MAX_N];
        int sCity, eCity, mCost, mHub;
        int cmd, ans, ret = 0;
        boolean okay = false;

        for (int i = 0; i < q; ++i) {
            cmd = sc.nextInt();
            switch (cmd) {
                case CMD_INIT:
                    okay = true;
                    n = sc.nextInt();
                    for (int j = 0; j < n; ++j) {
                        sCityArr[j] = sc.nextInt();
                        eCityArr[j] = sc.nextInt();
                        mCostArr[j] = sc.nextInt();
                    }
                    ans = sc.nextInt();
                    ret = usersolution.init(n, sCityArr, eCityArr, mCostArr);
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_ADD:
                    sCity = sc.nextInt();
                    eCity = sc.nextInt();
                    mCost = sc.nextInt();
                    usersolution.add(sCity, eCity, mCost);
                    break;
                case CMD_COST:
                    mHub = sc.nextInt();
                    ans = sc.nextInt();
                    ret = usersolution.cost(mHub);
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

        System.setIn(new java.io.FileInputStream("C:/Users/maema/Documents/dev/Algorithm_study/java/SWEA_java/24동계 SW알고리즘 역량강화 과정/S16245_sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();
        MARK = sc.nextInt();

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(sc) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        sc.close();
    }
}
