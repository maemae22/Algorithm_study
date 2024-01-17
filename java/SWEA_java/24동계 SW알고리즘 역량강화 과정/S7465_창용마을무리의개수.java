import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
public class S7465_창용마을무리의개수 {

    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            unf = new int[N+1];
            for (int i=1; i<=N; i++) {
                unf[i]=i;
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            List<Integer> list = new ArrayList<>();
            for (int i=1; i<=N; i++) {
                boolean find = false;
                for (int person : list) {
                    if (find(i)==find(person)) {
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    list.add(i);
                }
            }

            System.out.println("#"+testCase+" "+list.size());
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa!=fb) {
            unf[fa]=fb;
        }
    }

    public static int find(int a) {
        if (unf[a]==a) {
            return a;
        } else {
            return unf[a] = find(unf[a]);
        }
    }
}
