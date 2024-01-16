import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
public class S1233_사칙연산유효성검사 {

    static int answer = -1;
    static int[][] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase=1; testCase<=10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            tree = new int[N+1][4]; // 연산자(0)인지 숫자(1)인지, 자식1, 자식2, 자식2의 check 여부 순서로 저장
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                if (Character.isDigit(c)) {
                    tree[num][0]=1;
                } else {
                    tree[num][0]=0;
                }
                int index = 1;
                while (st.hasMoreTokens()) {
                    tree[num][index++] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 1;
            end = false;
            DFS(1, 0);
            System.out.println("#"+testCase+" "+answer);
        }
    }

    static boolean end = false;
    public static void DFS(int now, int parent) {
        if (end) {
            return;
        }

        if (tree[now][1]!=0) {
            DFS(tree[now][1], now);
            if (tree[now][3]==0) {
                DFS(tree[now][2], now);
            }
        } else {
            if (tree[now][0]==1 && tree[tree[parent][2]][0]==1 && tree[parent][0]==0) {
                tree[parent][0]=1;
                tree[parent][3]++;
            } else {
                answer = 0;
                end = true;
            }
        }
    }
}
