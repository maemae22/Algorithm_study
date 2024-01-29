import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/learn/course/subjectDetail.do?subjectId=AWWxxej6Ae4DFAW4
public class S3947_가장짧은길전부청소하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<int[]>> list = new ArrayList<>();
            for (int i=0; i<=N; i++) {
                list.add(new ArrayList<>());
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int[] tmp = new int[3];
                for (int j=0; j<3; j++) {
                    tmp[j] = Integer.parseInt(st.nextToken());
                }
                list.get(tmp[0]).add(new int[]{tmp[1], tmp[2]});
                list.get(tmp[1]).add(new int[]{tmp[0], tmp[2]});
            }

            PriorityQueue<Edge> q = new PriorityQueue<>();
            q.offer(new Edge(1, 0));

            long[] length = new long[N+1];
            Arrays.fill(length, Long.MAX_VALUE);
            length[0]=0;
            length[1]=0;

            long[] cost = new long[N+1];
            Arrays.fill(cost, Long.MAX_VALUE);
            cost[0]=0;
            cost[1]=0;

            while (!q.isEmpty()) {
                Edge tmp = q.poll();
                if (tmp.cost<=length[tmp.next]) {
                    for (int[] next : list.get(tmp.next)) {
                        if (tmp.cost+next[1]<length[next[0]]) {
                            length[next[0]] = tmp.cost+next[1];
                            cost[next[0]] = next[1];
                            q.offer(new Edge(next[0], length[next[0]]));
                        } else if (tmp.cost+next[1]==length[next[0]]) {
                            cost[next[0]] = Math.min(cost[next[0]], next[1]);
                        }
                    }
                }
            }

            long answer = 0;
            for (long tmp : cost) {
                answer += tmp;
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }
}

class Edge implements Comparable<Edge> {
    int next;
    long cost;
    Edge(int next, long cost) {
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.cost, o.cost);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "next=" + next +
                ", cost=" + cost +
                '}';
    }
}
