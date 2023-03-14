import java.util.*;
import java.io.*;

public class P01_기념품수집 {

    static int R, C, answer;
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스마다 이 로직 수행
        for (int test=1; test<=T; test++) {
            // 초기 세팅
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new char[R][C];
            for (int i=0; i<R; i++) {
                String row = br.readLine();
                for (int j=0; j<C; j++) {
                    arr[i][j] = row.charAt(j);
                }
            }

            // 로직
            // 방법1. BFS
//            BFS();

            // 방법2. DFS
            set = new HashSet<>();
            set.add(arr[0][0]);
            DFS(1, 0, 0);

            // 출력
            System.out.println("#"+test+" "+answer);
        }
    }

    // 방향 배열. 위, 아래, 오른쪽, 왼쪽
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void BFS() {

        Queue<Character> q = new LinkedList<>();
        q.offer(arr[0][0]);
        int count = 1;
    }

    static HashSet<Character> set;
    public static void DFS(int count, int x, int y) {
//        System.out.println(set);

        if (count == R*C) {
            answer = R*C;
        } else {
            for (int i=0; i<dx.length; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (isValid(nx, ny)) {
                    char nextGift = arr[nx][ny];
                    if (set.contains(nextGift)) {
                        answer = Math.max(answer, count);
                    } else {
                        set.add(nextGift);
                        DFS(count+1, nx, ny);
                        set.remove(nextGift);
                    }
                } else {
                    answer = Math.max(answer, count);
                }
            }
        }
    }

    // 이동할 방향이 가능한 방향인지 판별해주는 함수 (이동이 가능하면 true, 불가능하면 false를 return.)
    public static boolean isValid(int nx, int ny) {
        if (!(0<=nx && nx<R)) {
            return false;
        }
        if (!(0<=ny && ny<C)) {
            return false;
        }
        return true;
    }
}
