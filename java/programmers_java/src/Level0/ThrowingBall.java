package Level0;

public class ThrowingBall {
    public int solution(int[] numbers, int k) {
        int index = 1 + (k-1) * 2 ;
        return numbers[index%numbers.length -1];
    }
}
