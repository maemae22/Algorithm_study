package Practice;

import java.util.*;

public class FibonacciNumber {
    public int solution(int n) {
        List<Integer> fibo = new ArrayList<>();

        fibo.add(0);
        fibo.add(1);

        for(int i=2; i<=n; i++) {
            fibo.add( fibo.get(i-1)%1234567 + fibo.get(i-2)%1234567 );
        }

        return fibo.get(n)%1234567;
    }
}
