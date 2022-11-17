package Level0;

import java.util.*;

public class Ranking {
    public static int[] solution(int[][] score) {
        if (score.length ==1) {
            return new int[] {1};
        }

        int[] total = new int[score.length];

        for(int i=0; i<total.length; i++) {
            total[i] = score[i][0] + score[i][1];
        }

//        System.out.println(Arrays.toString(total));

        int[] copy = total.clone();
        Arrays.sort(copy);

        int[] sortDesc = new int[copy.length];
        int index = copy.length-1;
        for (int i=0; i< copy.length; i++) {
            sortDesc[i] = copy[index];
            index--;
        }

//        System.out.println(Arrays.toString(copy));

        int count = 1;
        int tmp = 0;
        Map<Integer, Integer> answerHint = new HashMap<>();
        for(int i=0; i<sortDesc.length; i++) {
            if( i!=sortDesc.length-1 && sortDesc[i] != sortDesc[i+1]) {
                answerHint.put(sortDesc[i], count);
//                System.out.println(sortDesc[i] + "/" +answerHint.get(sortDesc[i]));
                count++;
                count += tmp;
                tmp = 0;
            } else if (i==sortDesc.length-1) {
                answerHint.put(sortDesc[i], count);
            } else {
                tmp++;
            }
        }

//        System.out.println("150으로 가져오기" + answerHint.get(total[0]));

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++) {
            answer[i] = answerHint.get(total[i]);
//            System.out.println(total[i]);
//            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}})));
        System.out.println(Arrays.toString(solution(new int[][] {{80, 70}, {50, 80}})));
        System.out.println(Arrays.toString(solution(new int[][] {{80, 70}, {70, 80}})));
    }
}
