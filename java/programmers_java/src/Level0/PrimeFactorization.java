package Level0;

import java.util.*;

public class PrimeFactorization {
    public int[] solution(int n) {
        Set<Integer> answerSet = new HashSet<>();

        for(int i=2; i<=n; i++) {
            if(n%i == 0) {
                answerSet.add(i);
                while(n%i==0) {
                    n /= i;
                }
            }
        }

        int[] answer = new int[answerSet.size()];
        int index = 0;
        for(int tmp : answerSet) {
            answer[index] = tmp;
            index++;
        }

        Arrays.sort(answer);
        return answer;
    }
}
