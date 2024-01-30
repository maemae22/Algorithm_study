import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/learn/course/subjectDetail.do?subjectId=AWWxyoNqAiQDFAW4
public class S4007_간담회참석 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Road>> list = new ArrayList<>();
            ArrayList<ArrayList<Road>> listReverse = new ArrayList<>();
            for (int i=0; i<=N; i++) {
                list.add(new ArrayList<>());
                listReverse.add(new ArrayList<>());
            }
            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list.get(s).add(new Road(e, t));
                listReverse.get(e).add(new Road(s, t));
            }

            long[] a = dij(list, N, X);
            long[] b = dij(listReverse, N, X);

            long answer = 0;
            for (int i=1; i<=N; i++) {
                if (a[i]!=Long.MAX_VALUE && b[i]!=Long.MAX_VALUE) {
                    answer = Math.max(answer, a[i]+b[i]);
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    public static long[] dij(ArrayList<ArrayList<Road>> list, int N, int X) {
        long[] cost = new long[N+1];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[X]=0;

        PriorityQueue<Road> q = new PriorityQueue<>();
        q.offer(new Road(X, 0));

        while (!q.isEmpty()) {
            Road tmp = q.poll();
            if (tmp.cost<=cost[tmp.go]) {
                for (Road next : list.get(tmp.go)) {
                    if (tmp.cost+next.cost<cost[next.go]) {
                        cost[next.go]=tmp.cost+next.cost;
                        q.offer(new Road(next.go, cost[next.go]));
                    }
                }
            }
        }

        return cost;
    }
}

class Road implements Comparable<Road> {
    int go;
    long cost;
    Road(int go, long cost) {
        this.go = go;
        this.cost = cost;
    }
    @Override
    public int compareTo(Road o) {
        return Long.compare(this.cost, o.cost);
    }
}
