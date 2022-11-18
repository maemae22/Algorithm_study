package Level1;

public class Collatz {
    public int solution(int num) {
        int count = 0;

        if(num == 1) {
            return 0;
        }

        int tmp = num ;
        while(count<500) {
            if(tmp%2==0) {
                tmp /= 2;
            } else if(tmp%2==1) {
                tmp = tmp*3 + 1;
            }
            count++;

            if(tmp == 1) {
                return count;
            }
        }
        return -1;
    }
}
