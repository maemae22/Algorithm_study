import java.util.*;
import java.io.*;

// https://softeer.ai/practice/info.do?idx=1&eid=1309
public class 성적평가 {
    public static void main(String args[]) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] scores = new int[3][N];
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] total = new int[N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                total[i] += scores[j][i];
            }
        }

        // System.out.println(Arrays.deepToString(scores));
        // System.out.println(Arrays.toString(total));

        // 로직
        for(int i=0; i<3; i++) {
            System.out.println(emdtn(scores[i]));
        }
        System.out.println(emdtn(total));
    }

    // new int[N] 배열이 들어오면, 그 배열의 등수를 리턴하는 함수
    public static String emdtn(int[] score) {

        // 방법1. 2중 for문. 방법은 맞으나 시간 초과남.
        /*
        int[] answer = new int[score.length];

        for(int i=0; i<score.length; i++) {
            int count = 0;
            for(int j=0; j<score.length; j++) {
                if(score[i] < score[j]) {
                    count++;
                }
            }
            answer[i] = count+1;
        }

        StringBuilder br = new StringBuilder();
        for(int i=0; i<answer.length; i++) {
            br.append(answer[i]);
            br.append(" ");
        }

        return br.toString();
        */

        // 방법2. HashMap, Arrays.sort() 사용
        int[] copy = new int[score.length];
        for(int i=0; i<copy.length; i++) {
            copy[i] = score[i];
        }
        Arrays.sort(copy);

        // 예시
        // score : 200 700 300 700 300 1000
        // copy : 200 300 300 700 700 1000 (0 1 2 3 4 5) (6 4 4 2 2 1) - 전체 : 6개
        // return : 6 2 4 2 4 1

        HashMap<Integer, Integer> result = new HashMap<>();

        for(int i = score.length-1; i>=0; i--) {
            if(!result.containsKey(copy[i])) {
                result.put(copy[i], score.length-i);
            }
        }

        // System.out.println(Arrays.toString(score));
        // System.out.println(Arrays.toString(copy));
        // System.out.println(result);

        StringBuilder br = new StringBuilder();
        for(int i=0; i<score.length; i++) {
            br.append(result.get(score[i]));
            br.append(" ");
        }

        return br.toString();
    }
}
