import java.util.*;
import java.io.*;

class UserSolution_S12372_기초PartialSort연습 {

    private final static int MAX_INPUT = 100000;
    static int[][] data;
    static int size;

    public void init() {
        data = new int[MAX_INPUT*3+1][2];
        size = 0;
    }

    public void addUser(int uID, int income) {
        data[++size][0] = uID;
        data[size][1] = income;
        int index = size;
        int parent = size/2;
        while (parent!=0 && data[parent][1]<data[index][1] || data[parent][1]==data[index][1] && data[index][0]<data[parent][0]) {
            int tmpUid = data[parent][0];
            int tmpIncome = data[parent][1];
            data[parent][0] = data[index][0];
            data[parent][1] = data[index][1];
            data[index][0] = tmpUid;
            data[index][1] = tmpIncome;
            index = parent;
            parent = index/2;
        }
    }

    int getTop10(int[] result) {
        int count = 10<=size ? 10 : size;
        int[][] put = new int[count][2];
        for (int i=0; i<count; i++) {
            int[] tmp = poll();
            result[i] = tmp[0];
            put[i][0] = tmp[0];
            put[i][1] = tmp[1];
        }
        for (int i=0; i<count; i++) {
            addUser(put[i][0], put[i][1]);
        }
        return count;
    }

    int[] poll() {
        int[] top = new int[]{data[1][0], data[1][1]};
        data[1][0] = data[size][0];
        data[1][1] = data[size--][1];
        int parent = 1;
        int large = parent;
        while (true) {
            int lt = parent*2;
            int rt = parent*2+1;
            if (lt<=size && data[large][1]<data[lt][1] || data[large][1]==data[lt][1] && data[lt][0]<data[large][0]) {
                large = lt;
            }
            if (rt<=size && data[large][1]<data[rt][1] || data[large][1]==data[rt][1] && data[rt][0]<data[large][0]) {
                large = rt;
            }
            if (large==parent) {
                break;
            } else {
                int tmpUid = data[large][0];
                int tmpIncome = data[large][1];
                data[large][0] = data[parent][0];
                data[large][1] = data[parent][1];
                data[parent][0] = tmpUid;
                data[parent][1] = tmpIncome;
                parent = large;
            }
        }
        return top;
    }
}

public class S12372_기초PartialSort연습 {

    private final static int MAX_INPUT = 100000;
    private final static int MAX_NUM = 30000;

    private final static UserSolution_S12372_기초PartialSort연습 usersolution = new UserSolution_S12372_기초PartialSort연습();

    private static BufferedReader br;

    private static int[] input = new int[MAX_INPUT];
    private static long seed = 13410;

    private static long pseudoRand() {
        seed = (seed * 214013 + 2531011) & 0xffffffffL;
        return (seed>>11) % MAX_NUM;
    }

    private static void makeInput(int inputLen) {
        for(int i = 0; i < inputLen; i++) {
            input[i] = (int)(pseudoRand());
        }
    }

    private static int run() throws Exception {
        int score = 100;
        int N, userNum, uID = 0, ret, sum, ans;
        int[] result = new int[10];
        String str;

        str = br.readLine();
        N = Integer.parseInt(str);

        for(int i = 0; i < N; i++) {
            str = br.readLine();
            userNum = Integer.parseInt(str);
            makeInput(userNum);

            for(int j = 0; j < userNum; j++) {
                usersolution.addUser(uID++, input[j]);
            }
            ret = usersolution.getTop10(result);

            sum = 0;
            for(int j = 0; j < ret; j++) {
                sum += result[j];
            }

            str = br.readLine();
            ans = Integer.parseInt(str);
            if(sum != ans) {
                score = 0;
            }
        }
        return score;
    }

    public static void main(String[] args) throws Exception {
        int TC;
        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TC = Integer.parseInt(str);

        for (int tc = 1; tc <= TC; tc++) {
            usersolution.init();
            System.out.println("#" + tc + " " + run());
        }
    }
}
