package Level1;

public class IntegerSquareRoot {
    public long solution(long n) {
        double tmp = Math.sqrt(n);
        long tmpLong = (long)tmp;
        if(tmp == tmpLong) {
            return (long)((tmp+1)*(tmp+1));
        } else {
            return -1;
        }
    }
}
