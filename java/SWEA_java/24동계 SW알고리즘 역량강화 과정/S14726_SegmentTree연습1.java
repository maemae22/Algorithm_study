import java.util.*;
import java.io.*;

public class S14726_SegmentTree연습1 {

    static int[][] tree;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.print("#"+testCase+" ");

            tree = new int[N*4][2];
            init(1, 0, N-1, 0);
            init(1, 0, N-1, 1);

            for (int i=0; i<Q; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (a==0) {
                    update(1, 0, N-1, b, c, 0);
                    update(1, 0, N-1, b, c, 1);
                } else if (a==1) {
                    int max = findQuery(1, 0, N-1, b, c-1, 0);
                    int min = findQuery(1, 0, N-1, b, c-1, 1);
                    System.out.print((max-min)+" ");
                }
            }
            System.out.println();
        }
    }

    public static int init(int nodeIndex, int s, int e, int max) {
        if (s==e) {
            return tree[nodeIndex][max]=arr[s];
        }

        int mid = (s+e)/2;
        int a = init(nodeIndex*2, s, mid, max);
        int b = init(nodeIndex*2+1, mid+1, e, max);
        if (max==0) {
            return tree[nodeIndex][max]=Math.max(a, b);
        } else {
            return tree[nodeIndex][max]=Math.min(a, b);
        }
    }

    public static int findQuery(int nodeIndex, int ts, int te, int qs, int qe, int max) {
        if (qs<=ts && te<=qe) {
            return tree[nodeIndex][max];
        } else if (te<qs || qe<ts) {
            if (max==0) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            int mid = (ts+te)/2;
            int a = findQuery(nodeIndex*2, ts, mid, qs, qe, max);
            int b = findQuery(nodeIndex*2+1, mid+1, te, qs, qe, max);
            if (max==0) {
                return Math.max(a, b);
            } else {
                return Math.min(a, b);
            }
        }
    }

    public static int update(int nodeIndex, int s, int e, int updateIndex, int value, int max) {
        if (updateIndex<s || e<updateIndex) {
            return tree[nodeIndex][max];
        }

        if (s==e) {
            return tree[nodeIndex][max]=value;
        } else {
            int mid = (s+e)/2;
            int a = update(nodeIndex*2, s, mid, updateIndex, value, max);
            int b = update(nodeIndex*2+1, mid+1, e, updateIndex, value, max);
            if (max==0) {
                return tree[nodeIndex][max]=Math.max(a, b);
            } else {
                return tree[nodeIndex][max]=Math.min(a, b);
            }
        }
    }
}
