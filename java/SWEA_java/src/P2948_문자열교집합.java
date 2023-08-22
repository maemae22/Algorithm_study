import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-Un3G64SUDFAXr
public class P2948_문자열교집합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashSet<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                set.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<M; i++) {
                set.add(st.nextToken());
            }

            System.out.println("#"+testCase+" "+(N+M-set.size()));
        }
    }
}
