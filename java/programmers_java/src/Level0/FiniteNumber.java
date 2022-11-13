package Level0;

public class FiniteNumber {
    public int solution(int up, int down) {
        int max = Math.max(up, down);
        for(int i=2; i<=max; i++) {
            while(up%i==0 && down%i==0) {
                up /= i;
                down /=i;
            }
        }
        while(down%2==0) {
            down /= 2;
        }
        while(down%5==0) {
            down /=5;
        }

        if(down==1) {
            return 1;
        } else {
            return 2;
        }
    }
}
