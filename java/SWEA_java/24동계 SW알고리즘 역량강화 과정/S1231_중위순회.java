import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV140YnqAIECFAYD
public class S1231_중위순회 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase=1; testCase<=10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] tree = new int[N+1][4]; // 알파벳, 부모 개수, 자식1, 자식2 순서로 저장
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                tree[num][0]=(int)c;
                int index = 2;
                while (st.hasMoreTokens()) {
                    int child = Integer.parseInt(st.nextToken());
                    tree[num][index++] = child;
                    tree[child][1]++;
                }
            }

            int top = -1;
            for (int i=1; i<=N; i++) {
                if (tree[i][1]==0) {
                    top=i;
                    break;
                }
            }

            System.out.print("#"+testCase+" ");
            DFS(tree, top);
            System.out.println();
        }
    }

    public static void DFS(int[][] tree, int now) {
        if (tree[now][2]!=0) {
            DFS(tree, tree[now][2]);
            System.out.print((char)tree[now][0]);
            if (tree[now][3]!=0) {
                DFS(tree, tree[now][3]);
            }
        }
        if (tree[now][2]==0 && tree[now][3]==0) {
            System.out.print((char)tree[now][0]);
        }
    }
}
