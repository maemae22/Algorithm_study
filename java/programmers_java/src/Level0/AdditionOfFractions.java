package Level0;

public class AdditionOfFractions {

    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int beforeUp = denum1*num2 + denum2*num1;
        int beforeDown = num1 * num2 ;

        int max = Math.max(beforeUp, beforeDown);

        for(int i=2; i<=max; i++) {
            if(beforeUp%i ==0 && beforeDown%1 ==0) {
                while (beforeUp%i ==0 && beforeDown%i ==0) {
                    beforeUp /= i;
                    beforeDown /= i;
                }
            }
        }

        return new int[] {beforeUp, beforeDown};
    }


}
