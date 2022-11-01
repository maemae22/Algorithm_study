package Level1;

public class SumBetweenTwoNums {
    public long solution(int a, int b) {
        long sum = 0;

        if( a==b ) {
            return a;
        } else if (a<b) {
            for(int i=a; i<=b; i++) {
                sum += i;
            }
        } else { // a>b
            for(int i=b; i<=a; i++) {
                sum += i;
            }
        }
        return sum;
    }
}
