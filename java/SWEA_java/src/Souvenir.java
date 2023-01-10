import java.util.*;
        import java.io.*;

class Souvenir
{
    public static int R, C;
    public static int souvenirs; //정답
    public static boolean[] check; //중복확인
    public static char[][] city; // RxC 행렬
    //상하좌우 이동
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void DFS(int x, int y, int cnt) {
        if (souvenirs < cnt)  //최대는 26임
            souvenirs = cnt;
        else if (souvenirs == 26)
            return;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (Range(nx, ny) && !check[city[nx][ny] - 65]) {
                check[city[nx][ny] - 65] = true;
                DFS(nx, ny, cnt + 1);
                check[city[nx][ny] - 65] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            String[] rc = br.readLine().split(" ");

            R = Integer.parseInt(rc[0]);
            C = Integer.parseInt(rc[1]);

            souvenirs = 0;
            city = new char[R][C];
            check = new boolean[26];

            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    city[i][j] = line.charAt(j);
                }
            }
            check[city[0][0] - 65] = true;
            DFS(0, 0, 1);
            System.out.println("#"+test_case+" "+souvenirs);
        }

    }

    static boolean Range(int nx, int ny) {
        if (0 <= nx && nx < R && 0 <= ny && ny < C)
            return true;
        return false;
    }
}