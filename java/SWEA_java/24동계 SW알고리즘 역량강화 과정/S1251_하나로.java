import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
public class S1251_하나로 {

    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());

            unf = new int[N];
            for (int i=0; i<N; i++) {
                unf[i]=i;
            }

            PriorityQueue<Line> q = new PriorityQueue<>();
            for (int i=0; i<N; i++) {
                for (int j=i+1; j<N; j++) {
                    double L = E*(Math.pow(arr[i][0]-arr[j][0], 2)+Math.pow(arr[i][1]-arr[j][1], 2));
                    q.offer(new Line(i, j, L));
                }
            }

            double sum = 0;
            while (!q.isEmpty()) {
                Line tmp = q.poll();
                int a = tmp.a;
                int b = tmp.b;
                if (find(a)!=find(b)) {
                    union(a, b);
                    sum += tmp.cost;
                }
            }

            System.out.println("#"+testCase+" "+Math.round(sum));
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

class Line implements Comparable<Line> {
    int a;
    int b;
    double cost;
    Line(int a, int b, double cost) {
        this.a=a;
        this.b=b;
        this.cost=cost;
    }
    @Override
    public int compareTo(Line o) {
        return Double.compare(this.cost, o.cost);
    }
}
