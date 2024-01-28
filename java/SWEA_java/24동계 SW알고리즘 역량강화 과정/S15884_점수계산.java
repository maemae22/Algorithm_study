import java.util.*;
import java.io.*;

class UserSolution_S15884_점수계산 {

    static int[] team;
    static int[] teamScores;

    public void init(int N) {
        team = new int[N+1];
        for (int i=1; i<=N; i++) {
            team[i]=i;
        }
        teamScores = new int[N+1];
    }

    public void updateScore(int mWinnerID, int mLoserID, int mScore) {
        teamScores[find(mWinnerID)] += mScore;
        teamScores[find(mLoserID)] -= mScore;
    }

    public void unionTeam(int mPlayerA, int mPlayerB) {
        int teamA = find(mPlayerA);
        int teamB = find(mPlayerB);
        team[teamA] = teamB;
        teamScores[teamA] -= teamScores[teamB];
    }

    public int getScore(int mID) {
        int myTeam = find(mID);
        if (myTeam==mID) {
            return teamScores[mID];
        } else {
            return teamScores[mID]+teamScores[myTeam];
        }
    }

    public int find(int a) {
        if (team[a]==a) {
            return a;
        } else {
            int nowTeam = find(team[a]);
            if (nowTeam!=team[a]) {
                teamScores[a] += teamScores[team[a]];
            }
            team[a] = nowTeam;
            return team[a];
        }
    }
}

public class S15884_점수계산 {

    private static BufferedReader br;
    private static final UserSolution_S15884_점수계산 userSolution = new UserSolution_S15884_점수계산();

    private final static int CMD_INIT = 100;
    private final static int CMD_UPDATE_SCORE = 200;
    private final static int CMD_UNION_TEAM = 300;
    private final static int CMD_GET_SCORE = 400;

    private static boolean run() throws IOException {
        int queryCnt = Integer.parseInt(br.readLine());
        boolean okay = false;
        int res, ans;

        for (int i = 0; i < queryCnt; i++) {
            StringTokenizer stdin = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(stdin.nextToken())) {
                case CMD_INIT:
                    int N = Integer.parseInt(stdin.nextToken());
                    userSolution.init(N);
                    okay = true;
                    break;
                case CMD_UPDATE_SCORE:
                    int mWinnerID = Integer.parseInt(stdin.nextToken());
                    int mLoserID = Integer.parseInt(stdin.nextToken());
                    int mScore = Integer.parseInt(stdin.nextToken());
                    userSolution.updateScore(mWinnerID, mLoserID, mScore);
                    break;
                case CMD_UNION_TEAM:
                    int mPlayerA = Integer.parseInt(stdin.nextToken());
                    int mPlayerB = Integer.parseInt(stdin.nextToken());
                    userSolution.unionTeam(mPlayerA, mPlayerB);
                    break;
                case CMD_GET_SCORE:
                    int mID = Integer.parseInt(stdin.nextToken());
                    res = userSolution.getScore(mID);
                    ans = Integer.parseInt(stdin.nextToken());
                    if (ans != res) {
                        okay = false;
                    }
                    break;
            }
        }

        return okay;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("C:/Users/maema/Documents/dev/Algorithm_study/java/SWEA_java/24동계 SW알고리즘 역량강화 과정/S15884_sample_input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stinit = new StringTokenizer(br.readLine(), " ");

        int T, MARK;
        T = Integer.parseInt(stinit.nextToken());
        MARK = Integer.parseInt(stinit.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            int score = run() ? MARK : 0;
            System.out.printf("#%d %d\n", tc, score);
        }

        br.close();
    }
}
