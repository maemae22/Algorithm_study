package Level1;

public class Average {
    public double solution(int[] arr) {
        int sum = 0;
        for(int tmp : arr) {
            sum += tmp;
        }

        return (double) sum / arr.length;
    }
}
