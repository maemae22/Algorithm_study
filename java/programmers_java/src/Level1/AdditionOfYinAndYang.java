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

    public int solution2(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i<signs.length; i++)
            answer += absolutes[i] * (signs[i]? 1: -1);
        return answer;
    }

    public int solution3(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += (signs[i]) ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }

    public int solution4(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
