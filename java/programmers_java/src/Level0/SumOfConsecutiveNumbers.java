package Level0;

public class SumOfConsecutiveNumbers {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int first = 0;

        if(num%2 == 0) {
            first = total/num - num/2 +1;
        } else {
            first = total/num - num/2;
        }

        for(int i=0; i<num; i++) {
            answer[i] = first;
            first++;
        }

        return answer;
    }


}
