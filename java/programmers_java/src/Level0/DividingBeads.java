package Level0;

import java.math.BigInteger;
import java.util.*;

public class DividingBeads {

    // 숫자 범위 때문에 오류남
//    public int solution(int balls, int share) {
//        double up = fact(balls);
//        double down = fact(balls-share) * fact(share);
//
//        double answer = up/down;
//
//        return (int)answer;
//    }
//
//    public double fact(int n) {
//        double answer = 1;
//        for(int i=1; i<=n; i++) {
//            answer *= i;
//        }
//        return answer;
//    }

    public int solution(int balls, int share) {
        if(balls==share || share==0) {
            return 1;
        }
        return solution(balls-1, share-1) + solution(balls-1, share);
    }

}
