import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 부자의꿈 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int answer = 0;

            int[][] arr = new int[N+1][M+1];
            int[] maxX = new int[N+1];
            int[] maxY = new int[M+1];

            for (int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxX[i] = Math.max(maxX[i], arr[i][j]);
                    maxY[j] = Math.max(maxY[j], arr[i][j]);
                }
            }

            Queue<Place> safe = new LinkedList<>();
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=M; j++) {
                    if (arr[i][j]==maxX[i] && arr[i][j]==maxY[j]) {
                        safe.add(new Place(i, j));
                    }
                }
            }

            for (int i=0; i<Q; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                maxX[x] = Math.max(maxX[x], z);
                maxY[y] = Math.max(maxY[y], z);

                int size = safe.size();
                if (maxX[x]==z && maxY[y]==z) {
                    for (int k=0; k<size; k++) {
                        Place tmp = safe.poll();
                        if (tmp.x!=x && tmp.y!=y) {
                            safe.add(tmp);
                        }
                    }
                    safe.add(new Place(x, y));
                } else if (maxX[x]==z) {
                    for (int k=0; k<size; k++) {
                        Place tmp = safe.poll();
                        if (tmp.x!=x) {
                            safe.add(tmp);
                        }
                    }
                } else if (maxY[y]==z) {
                    for (int k=0; k<size; k++) {
                        Place tmp = safe.poll();
                        if (tmp.y!=y) {
                            safe.add(tmp);
                        }
                    }
                }
                answer += safe.size();
            }

            System.out.println("#"+testCase+" "+answer);
        }
        br.close();
    }

    static class Place {
        int x;
        int y;
        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
