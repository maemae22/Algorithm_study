import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
public class S1249_보급로 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i=0; i<N; i++) {
                String line = br.readLine();
                for (int j=0; j<N; j++) {
                    arr[i][j] = line.charAt(j)-'0';
                }
            }

            PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0]-b[0];
                }
            });
            q.offer(new int[]{0, 0, 0});

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            int[][] check = new int[N][N];
            check[0][0] = 1;
            int answer = 0;

            while (!q.isEmpty() && answer==0) {
                int[] min = q.poll();
                for (int k=0; k<4; k++) {
                    int nx = min[1]+dx[k];
                    int ny = min[2]+dy[k];
                    if (0<=nx && nx<N && 0<=ny && ny<N && check[nx][ny]==0) {
                        check[nx][ny]=1;
                        int cost = min[0]+arr[nx][ny];
                        if (nx==N-1 && ny==N-1) {
                            answer = cost;
                        } else {
                            q.offer(new int[]{cost, nx, ny});
                        }
                    }
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }
}
