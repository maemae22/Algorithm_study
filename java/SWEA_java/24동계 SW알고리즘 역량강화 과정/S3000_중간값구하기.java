import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-fO0s6ARoDFAXT
public class S3000_중간값구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            max.offer(A);
            int answer = 0;
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                min.offer(X);
                max.offer(Y);
                if (max.peek()>min.peek()) {
                    max.offer(min.poll());
                    min.offer(max.poll());
                }
                answer += max.peek()%20171109;
                answer = answer%20171109;
            }
            System.out.println("#"+testCase+" "+answer);
        }
    }
}
