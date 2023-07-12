import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 민석이의마니또 {

    static int tmp = Integer.MAX_VALUE;
    static int answer = Integer.MAX_VALUE;
    static int[] check;
    static ArrayList<Line>[] lines;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=1; testCase<=T; testCase++) {
            answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            // line 인접 리스트 만들기
            lines = new ArrayList[N+1];
            for (int i=1; i<=N; i++) {
                lines[i] = new ArrayList<>();
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                lines[X].add(new Line(X, Y, C));
            }

            for (int i=1; i<=N; i++) {
                check = new int[N+1];
                check[i] = 1;
                tmp = Integer.MAX_VALUE;
                DFS(i, i, 0);
                answer = Math.min(answer, tmp);
            }

            answer = answer==Integer.MAX_VALUE ? -1 : answer;
            System.out.println("#"+testCase+" "+answer);
        }
        br.close();
    }

    public static void DFS(int start, int now, int cost) {
        if (tmp<=cost || answer<=cost) {
            return;
        }
        if (check[now]==2 && start==now) {
            tmp = Math.min(tmp, cost);
        } else {
            for (Line line : lines[now]) {
                if (check[line.end]==0 || (check[line.end]==1&&start==line.end)) {
                    check[line.end]++;
                    DFS(start, line.end, cost+line.cost);
                    check[line.end]--;
                }
            }
        }
    }

    static class Line {
        int start;
        int end;
        int cost;

        Line(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
