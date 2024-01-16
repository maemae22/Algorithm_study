import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD
public class S1248_공통조상 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for (int i=0; i<4; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[][] tree = new int[arr[0]+1][4]; // [부모 노드 번호, 자식1, 자식2, 자식 개수] 순서로 저장
            while (st.hasMoreTokens()) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                tree[child][0]=parent;
                tree[parent][3]++;
                tree[parent][tree[parent][3]]=child;
            }

            Set<Integer> parents = new HashSet<>();
            int me = arr[2];
            while (tree[me][0]!=0) {
                parents.add(tree[me][0]);
                me = tree[me][0];
            }

            me = arr[3];
            int num = 0;
            while (num==0) {
                int parent = tree[me][0];
                if (parents.contains(parent)) {
                    num = parent;
                } else {
                    me = parent;
                }
            }

            int count = 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(num);
            while (!q.isEmpty()) {
                int tmp = q.poll();
                count += tree[tmp][3];
                for (int k=1; k<=tree[tmp][3]; k++) {
                    q.offer(tree[tmp][k]);
                }
            }

            System.out.println("#"+testCase+" "+num+" "+count);
        }
    }
}
