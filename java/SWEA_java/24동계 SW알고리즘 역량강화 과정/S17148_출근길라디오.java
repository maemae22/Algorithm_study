import java.util.*;
import java.io.*;

class UserSolution_S17148_출근길라디오 {

    static int[][] arr;
    static int[] tree;
    static int S;

    void init(int N, int M, int mType[], int mTime[]) {
        S=N;
        arr = new int[N][2];
        for (int i=0; i<N-1; i++) {
            arr[i][0]=mType[i];
            arr[i][1]=mTime[i];
        }

        tree = new int[N*4];
        init(1, 0, N-1);
    }

    void destroy() {

    }

    void update(int mID, int mNewTime) {
        arr[mID][1]=mNewTime;
        updateValue(1, 0, S-1, mID, mNewTime);
    }

    int updateByType(int mTypeID, int mRatio256) {
        ArrayList<Integer> roads = new ArrayList<>();
        for (int i=0; i<S; i++) {
            if (arr[i][0]==mTypeID) {
                roads.add(i);
            }
        }

        int sum = 0;
        for (int road : roads) {
            int value = arr[road][1]*mRatio256/256;
            sum += value;
            arr[road][1]=value;
            updateValue(1, 0, S-1, road, value);
        }
        return sum;
    }

    int calculate(int mA, int mB) {
        if (mA>mB) {
            int tmp = mA;
            mA = mB;
            mB = tmp;
        }
        return findQuery(1, 0, S-1, mA, mB-1);
    }

    int init(int treeIndex, int s, int e) {
        if (s==e) {
            return tree[treeIndex]=arr[s][1];
        }

        int mid = (s+e)/2;
        int a = init(treeIndex*2, s, mid);
        int b = init(treeIndex*2+1, mid+1, e);
        return tree[treeIndex]=a+b;
    }

    int updateValue(int treeIndex, int s, int e, int updateIndex, int value) {
        if (updateIndex<s || e<updateIndex) {
            return tree[treeIndex];
        } else {
            if (s==e) {
                return tree[treeIndex]=value;
            } else {
                int mid = (s+e)/2;
                int a = updateValue(treeIndex*2, s, mid, updateIndex, value);
                int b = updateValue(treeIndex*2+1, mid+1, e, updateIndex, value);
                return tree[treeIndex]=a+b;
            }
        }
    }

    int findQuery(int treeIndex, int ts, int te, int qs, int qe) {
        if (qs<=ts && te<=qe) {
            return tree[treeIndex];
        } else if (te<qs || qe<ts) {
            return 0;
        } else {
            int mid = (ts+te)/2;
            int a = findQuery(treeIndex*2, ts, mid, qs, qe);
            int b = findQuery(treeIndex*2+1, mid+1, te, qs, qe);
            return a+b;
        }
    }
}

public class S17148_출근길라디오 {

    private static UserSolution_S17148_출근길라디오 usersolution = new UserSolution_S17148_출근길라디오();
    static final int CMD_INIT = 100;
    static final int CMD_DESTROY = 200;
    static final int CMD_UPDATE = 300;
    static final int CMD_UPDATE_TYPE = 400;
    static final int CMD_CALC = 500;
    static final int MAX_N = 100000;
    static int[] mType = new int [MAX_N];
    static int[] mTime = new int [MAX_N];

    private static boolean run(BufferedReader br) throws IOException  {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean isOK = false;
        int C = new Scanner(st.nextToken()).nextInt();
        int cmd, result, check;
        int N, M;
        int mID, mTypeID, mNewTime, mRatio256;
        int mA, mB;
        for (int c = 0; c < C; ++c) {
            st = new StringTokenizer(br.readLine(), " ");
            cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case CMD_INIT:
                    N = new Scanner(st.nextToken()).nextInt();
                    M = new Scanner(st.nextToken()).nextInt();
                    for (int i = 0; i < N - 1; i++) mType[i] = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < N - 1; i++) mTime[i] = Integer.parseInt(st.nextToken());
                    usersolution.init(N, M, mType, mTime);
                    isOK = true;
                    break;
                case CMD_UPDATE:
                    mID = Integer.parseInt(st.nextToken());
                    mNewTime = Integer.parseInt(st.nextToken());
                    usersolution.update(mID, mNewTime);
                    break;
                case CMD_UPDATE_TYPE:
                    mTypeID = new Scanner(st.nextToken()).nextInt();
                    mRatio256 = new Scanner(st.nextToken()).nextInt();
                    result = usersolution.updateByType(mTypeID, mRatio256);
                    check = new Scanner(st.nextToken()).nextInt();
                    if (result != check)
                        isOK = false;
                    break;
                case CMD_CALC:
                    mA = Integer.parseInt(st.nextToken());
                    mB = Integer.parseInt(st.nextToken());
                    result = usersolution.calculate(mA, mB);
                    check = Integer.parseInt(st.nextToken());
                    if (result != check)
                        isOK = false;
                    break;
                default:
                    isOK = false;
                    break;
            }
        }
        usersolution.destroy();
        return isOK;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("C:/Users/maema/Documents/dev/Algorithm_study/java/SWEA_java/24동계 SW알고리즘 역량강화 과정/S17148_sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine(), " ");
        int TC = Integer.parseInt(line.nextToken());
        int MARK = Integer.parseInt(line.nextToken());
        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }
        br.close();
    }
}
