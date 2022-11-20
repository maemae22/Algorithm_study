package Level1;

import java.util.*;

// 레벨1 - 예산
public class Budget {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int total = 0;
        for(int i=0; i<d.length; i++) {
            if(total+d[i]<=budget) {
                total += d[i];
            } else {
                return i;
            }
        }
        return d.length;
    }
}
