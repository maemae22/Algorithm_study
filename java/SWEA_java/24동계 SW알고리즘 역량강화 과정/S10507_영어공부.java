import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXNQOb3avD0DFAXS
public class S10507_영어공부 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int[] study = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                study[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(study);
            int[] arr = new int[study[study.length-1]+P+1];
            for (int tmp : study) {
                arr[tmp]++;
            }

            int lt = 1;
            int rt = N+P;
            int answer = -1;
            while (lt<=rt) {
                int mid = (lt+rt)/2;
                if (canStudy(arr, P, mid)) {
                    answer = mid;
                    lt = mid+1;
                } else {
                    rt = mid-1;
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    public static boolean canStudy(int[] arr, int change, int days) {
        int lt = 1;
        int rt = 1;
        int count = 0;
        while (lt<=rt && rt<arr.length) {
            while (rt<arr.length && count<=change) {
                if (arr[rt]==0) {
                    count++;
                }
                if (count==change) {
                    while (rt+1<arr.length && arr[rt+1]==1) {
                        rt++;
                    }
                    break;
                }
                rt++;
            }
            if (days<=rt-lt+1 || rt==arr.length && days<=rt-lt) {
                return true;
            }
            while (lt<arr.length && count==change) {
                if (arr[lt]==0) {
                    count--;
                }
                lt++;
            }
            rt++;
        }

        return false;
    }
}
