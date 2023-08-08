import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXNQOb3avD0DFAXS
public class P10507_영어공부 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            /* 방법1. 이분 탐색 활용 (시간 초과)
            int lt = 1;
            int rt = n+p;
            while (lt<=rt) {
                int mid = (lt+rt)/2;
                if (canContinue(arr, p, mid)) {
                    lt=mid+1;
                } else {
                    rt=mid-1;
                }
            }

            System.out.println("#"+testCase+" "+(lt-1));
             */

            int[] days = new int[arr[arr.length-1]+1+p];
            for (int i=0; i<n; i++) {
                days[arr[i]]=1;
            }

            int lt = 0;
            int change = 0;
            int answer = 0;

            for (int rt=0; rt<days.length; rt++) {
                if (days[rt]==0) {
                    change++;
                }

                if (change>p) {
                    while (days[lt]==1) {
                        lt++;
                    }
                    change--;
                    lt++;
                }

                answer = Math.max(answer, rt-lt+1);
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    public static boolean canContinue(int[] arr, int plus, int count) {
        for (int i=0; i<arr.length; i++) {
            int start = arr[i]+plus;
            int cnt = 1+plus;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j]<=start) {
                    start++;
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt>=count) {
                return true;
            }
        }
        return false;
    }
}
