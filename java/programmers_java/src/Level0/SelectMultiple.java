package Level0;

import java.util.*;

public class SelectMultiple {
    public static int[] solution(int n, int[] numlist) {
        List<Integer> answer = new ArrayList<>();

        for(int num : numlist) {
            if(num%n==0) {
                answer.add(num);
            }
        }

        int[] answerArr = new int[answer.size()];
        for(int i =0 ; i<answerArr.length; i++) {
            answerArr[i] = answer.get(i);
        }

        return answerArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12})));
    }

}
