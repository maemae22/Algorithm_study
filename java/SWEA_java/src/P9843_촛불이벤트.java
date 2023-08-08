import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXGBKzuaPOoDFAXR
public class P9843_촛불이벤트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=1; testCase<=T; testCase++) {
            long N = Long.parseLong(br.readLine());
            long answer = -1;

            long lt = 1L;
            long rt = (long) Math.pow(2*N, 0.5);
            while (lt<=rt) {
                long mid = (lt+rt)/2;
                long require = canMake(mid);
                if (require==N) {
                    answer = mid;
                    break;
                } else if (require>N) {
                    rt = mid-1;
                } else {
                    lt = mid+1;
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    // target단의 삼각형을 만드는데 필요한 촛불의 개수를 반환
    public static long canMake(long target) {
        return target*(target+1)/2;
    }
}
