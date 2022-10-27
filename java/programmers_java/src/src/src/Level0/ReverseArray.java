package src.src.Level0;

import java.util.Arrays;

public class ReverseArray {
    public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i=0 ; i<answer.length; i++) {
            answer[i] = num_list[num_list.length - i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
    }
}
