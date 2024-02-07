import java.util.*;
import java.io.*;

public class S14733_SegmentTree연습2 {

    static int[] arr;
    static long[][] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            arr = new int[N];
            tree = new long[N*4][2];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.print("#"+testCase+" ");

            init(1, 0, N-1, 0);
            init(1, 0, N-1, 1);
            for (int i=0; i<Q; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (a==0) {
                    update(1, 0, N-1, b, c, b%2);
                } else if (a==1) {
                    long plus = findQuery(1, 0, N-1, b, c-1, b%2);
                    long minus = findQuery(1, 0, N-1, b, c-1, (b+1)%2);
                    System.out.print((plus-minus)+" ");
                }
            }
            System.out.println();
        }
    }

    public static long init(int treeIndex, int s, int e, int oddOrEven) {
        if (s==e) {
            if (s%2==oddOrEven) {
                return tree[treeIndex][oddOrEven]=arr[s];
            } else {
                return 0;
            }
        }

        int mid = (s+e)/2;
        long a = init(treeIndex*2, s, mid, oddOrEven);
        long b = init(treeIndex*2+1, mid+1, e, oddOrEven);
        return tree[treeIndex][oddOrEven]=a+b;
    }

    public static long findQuery(int treeIndex, int ts, int te, int qs, int qe, int oddOrEven) {
        if (te<qs || qe<ts) {
            return 0;
        } else if (qs<=ts && te<=qe) {
            return tree[treeIndex][oddOrEven];
        } else {
            int mid = (ts+te)/2;
            long a = findQuery(treeIndex*2, ts, mid, qs, qe, oddOrEven);
            long b = findQuery(treeIndex*2+1, mid+1, te, qs, qe, oddOrEven);
            return a+b;
        }
    }

    public static long update(int treeIndex, int s, int e, int updateIndex, int value, int oddOrEven) {
        if (updateIndex%2==oddOrEven) {
            if (updateIndex<s || e<updateIndex) {
                return tree[treeIndex][oddOrEven];
            } else if (s==e) {
                return tree[treeIndex][oddOrEven]=value;
            } else {
                int mid = (s+e)/2;
                long a = update(treeIndex*2, s, mid, updateIndex, value, oddOrEven);
                long b = update(treeIndex*2+1, mid+1, e, updateIndex, value, oddOrEven);
                return tree[treeIndex][oddOrEven]=a+b;
            }
        }
        return 0;
    }
}
