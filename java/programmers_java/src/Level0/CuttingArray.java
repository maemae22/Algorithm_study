package Level0;

import java.util.Arrays;

public class CuttingArray {
    public static int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        System.arraycopy(numbers, num1, answer, 0, answer.length);
//        for(int i=0 ; i<answer.length; i++) {
//            answer[i] = numbers[num1+i];
//        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,3,5}, 1, 2)));
    }
}
