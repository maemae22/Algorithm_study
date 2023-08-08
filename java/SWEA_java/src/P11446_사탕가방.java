import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXdHxTNqC2IDFAS5
public class P11446_사탕가방 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            long[] arr = new long[N];
            st = new StringTokenizer(br.readLine());
            long max = 0;
            for (int i=0; i<N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            long lt = 0;
            long rt = max;
            while (lt<=rt) {
                long mid = (lt+rt)/2;
                if (canDivide(arr, M, mid)) {
                    lt = mid+1;
                } else {
                    rt = mid-1;
                }
            }

            System.out.println("#"+testCase+" "+(lt-1));
        }
    }

    // arr 배열의 사탕을 가방 안에 정확히 M개의 사탕이 들어 있게 나눴을 때,
    // count 개수 만큼의 사탕 가방을 만들 수 있으면 true, 없으면 false 반환함
    public static boolean canDivide(long[] arr, long M, long count) {
        if (count==0) {
            return true;
        }

        long sum = 0;
        for (long tmp : arr) {
            sum += tmp/count;
            if (sum>=M) {
                return true;
            }
        }
        return false;
    }
}
