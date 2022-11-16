package Level0;

import java.util.*;

public class OverlappingSegments {
    public int solution(int[][] lines) {
        Map<Integer, Integer> total = new HashMap<>();

        for(int[] line : lines) {
            for(int i=line[0]; i<line[1]; i++) {
                if(total.containsKey(i)) {
                    total.put(i, total.get(i)+1);
                } else {
                    total.put(i, 1);
                }
            }
        }

        int count = 0;
        for(Integer value : total.values()) {
            if(value != 1) {
                count++;
            }
        }
        return count;
    }
}
