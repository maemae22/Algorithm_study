import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXdHxTNqC2IDFAS5
public class S11446_사탕가방 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[N];
            for (int i=0; i<N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(arr);

            long lt = 1;
            long rt = arr[arr.length-1];
            long answer = 0;
            while (lt<=rt) {
                long mid = (lt+rt)/2;
                if (canMake(arr, M, mid)) {
                    answer = mid;
                    lt = mid+1;
                } else {
                    rt = mid-1;
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    public static boolean canMake(long[] arr, long total, long count) {
        long sum = 0;
        for (long tmp : arr) {
            sum += tmp/count;
        }
        if (total<=sum) {
            return true;
        } else {
            return false;
        }
    }
}
