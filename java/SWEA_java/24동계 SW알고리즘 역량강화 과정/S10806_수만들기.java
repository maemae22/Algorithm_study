import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXTC4piqD_IDFASe
public class S10806_수만들기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0]-b[0];
                }
            });
            q.offer(new int[]{0, K});
            while (q.peek()[1]!=0) {
                int[] min = q.poll();
                q.offer(new int[]{min[0]+min[1], 0});
                for (int tmp : arr) {
                    q.offer(new int[]{min[0]+min[1]%tmp, min[1]/tmp});
                }
            }

            System.out.println("#"+testCase+" "+q.poll()[0]);
        }
    }
}
