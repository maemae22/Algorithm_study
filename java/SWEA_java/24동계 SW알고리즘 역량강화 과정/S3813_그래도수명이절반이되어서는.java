import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/learn/course/subjectDetail.do?subjectId=AWWxo6c6AVkDFAW4#
public class S3813_그래도수명이절반이되어서는 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] w = new int[N];
            int[] s = new int[K];
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int i=0; i<N; i++) {
                w[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, w[i]);
            }
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<K; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            int lt = 1;
            int rt = max;
            int answer = -1;
            while (lt<=rt) {
                int mid = (lt+rt)/2;
                if (can(w, s, mid)) {
                    answer = mid;
                    rt = mid-1;
                } else {
                    lt = mid+1;
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    public static boolean can(int[] w, int[] s, int max) {
        int ps = 0;
        int count = 0;
        for (int pw=0; pw<w.length; pw++) {
            if (w[pw]<=max) {
                count++;
                if (count==s[ps]) {
                    ps++;
                    count = 0;
                }
                if (ps==s.length) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }
}
