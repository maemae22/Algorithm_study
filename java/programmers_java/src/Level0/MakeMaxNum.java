package Level0;

import java.util.Arrays;

public class MakeMaxNum {
    public static int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1]*numbers[numbers.length-2];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 7, 8}));
    }


}
