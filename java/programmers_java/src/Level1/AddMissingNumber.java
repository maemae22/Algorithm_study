package Level1;

public class AddMissingNumber {
    public int solution(int[] numbers) {
        int[] num = new int[10];
        for(int tmp : numbers) {
            num[tmp] = tmp;
        }

        int answer=0;
        for(int i=0; i<num.length; i++) {
            if(num[i] == 0) {
                answer += i;
            }
        }
        return answer;
    }
}
