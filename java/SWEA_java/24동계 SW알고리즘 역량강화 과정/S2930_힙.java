import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-Tj7ya3jYDFAXr
public class S2930_힙 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            System.out.print("#"+testCase+" ");
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int query = Integer.parseInt(st.nextToken());
                if (query==1) {
                    q.offer(Integer.parseInt(st.nextToken()));
                } else if (query==2) {
                    if (q.isEmpty()) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(q.poll()+" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
