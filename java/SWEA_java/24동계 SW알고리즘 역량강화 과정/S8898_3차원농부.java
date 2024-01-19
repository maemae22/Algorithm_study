import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW45TzHae8UDFAQ7
public class S8898_3차원농부 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int[] a = new int[N];
            int[] b = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);

            long min = Long.MAX_VALUE;
            long count = 0;
            for (int i=0; i<N; i++) {
                int[] len;
                if (a[i]<=b[0]) {
                    len = new int[]{Math.abs(b[0]-a[i])};
                } else if (b[b.length-1]<=a[i]) {
                    len = new int[]{Math.abs(b[b.length-1]-a[i])};
                } else {
                    int index = findNearIndex(b, a[i]);
                    len = new int[]{Math.abs(b[index]-a[i]), Math.abs(b[index+1]-a[i])};
                }
                for (int tmp : len) {
                    if (tmp<min) {
                        min=tmp;
                        count=1;
                    } else if (tmp==min) {
                        count++;
                    }
                }
            }
            min += Math.abs(c1-c2);

            System.out.println("#"+testCase+" "+min+" "+count);
        }
    }

    public static int findNearIndex(int[] arr, int target) {
        int lt = 0;
        int rt = arr.length-1;
        int answer = -1;
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (arr[mid]<=target) {
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }

        return answer;
    }
}
