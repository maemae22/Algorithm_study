import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141J8KAIcCFAYD
public class S1232_사칙연산 {

    static double[][] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase=1; testCase<=10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            // index : 정점 번호 - Node 값(+-*/ = -1~-4로 표현), 자식1, 자식2, 부모 개수로 저장
            tree = new double[N+1][4];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                char c = value.charAt(0);
                if (c=='+') {
                    tree[num][0]=-1;
                } else if (c=='-') {
                    tree[num][0]=-2;
                } else if (c=='*') {
                    tree[num][0]=-3;
                } else if (c=='/') {
                    tree[num][0]=-4;
                } else {
                    tree[num][0]=Integer.parseInt(value);
                }
                int index = 1;
                while (st.hasMoreTokens()) {
                    int tmp = Integer.parseInt(st.nextToken());
                    tree[num][index++] = tmp;
                    tree[tmp][3]++;
                }
            }

            int top = -1;
            for (int i=1; i<=N; i++) {
                if (tree[i][3]==0) {
                    top=i;
                    break;
                }
            }

            DFS(top);
            System.out.println("#"+testCase+" "+(int)(tree[top][0]));
        }
    }

    public static void DFS(int now) {
        if (tree[now][1]!=0) { // 자식 노드가 있는 경우
            int child1 = (int)tree[now][1];
            int child2 = (int)tree[now][2];
            if (-4<=tree[child1][0] && tree[child1][0]<=-1) {
                DFS(child1);
            }
            if (-4<=tree[child2][0] && tree[child2][0]<=-1) {
                DFS(child2);
            }
            int cal = (int)tree[now][0];
            if (cal==-1) {
                tree[now][0]=tree[child1][0]+tree[child2][0];
            } else if (cal==-2) {
                tree[now][0]=tree[child1][0]-tree[child2][0];
            } else if (cal==-3) {
                tree[now][0]=tree[child1][0]*tree[child2][0];
            } else if (cal==-4) {
                tree[now][0]=tree[child1][0]/tree[child2][0];
            }
        }
    }
}
