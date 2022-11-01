package Level1;

public class MakeReverseNumArr {
    public int[] solution(long n) {
        /*
        String[] num = (n+"").split("");

        int[] answer = new int[num.length];

        int index = 0;
        for(int i=num.length-1; i>=0; i--) {
            answer[index] = Integer.parseInt(num[i]);
            index++;
        }
        return answer;
        */

        int[] answer = new int[(n+"").length()];
        int index = 0;
        while(n>0) {
            answer[index] = (int)(n%10) ;
            n /= 10;
            index++;
        }
        return answer;
    }
}
