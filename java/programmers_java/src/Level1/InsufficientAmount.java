package Level1;

public class InsufficientAmount {
    public long solution(int price, int money, int count) {
        long total = 0;
        for(int i=1; i<=count; i++) {
            total += i*price;
        }

        if(money-total>=0) {
            return 0;
        } else {
            return total-money;
        }
    }
}
