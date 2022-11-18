package Level1;

public class AdditionOfYinAndYang {
    public int solution(int[] absolutes, boolean[] signs) {
        int[] arr = new int[signs.length];

        int number;
        for(int i=0; i<arr.length; i++) {
            if(signs[i] == true) {
                number = 1;
            } else {
                number = -1;
            }
            arr[i] = absolutes[i] * number;
        }

        int answer = 0;
        for(int tmp : arr) {
            answer += tmp;
        }
        return answer;
    }
}
