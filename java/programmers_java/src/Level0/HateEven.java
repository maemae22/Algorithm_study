package Level0;

import java.util.Arrays;

public class HateEven {
    public static int[] solution(int n) {
        int[] answer = new int[n%2==0? n/2 : n/2+1];
        for(int i=0 ; i<answer.length; i++) {
            answer[i] = i*2 + 1 ;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(15)));
    }
}
