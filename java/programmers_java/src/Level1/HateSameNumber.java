package Level1;

import java.util.*;

public class HateSameNumber {
    public int[] solution(int []arr) {
        List<Integer> all = new ArrayList<>();

        int index = 1;
        all.add(arr[0]);

        for(int i=1; i<arr.length; i++) {
            if(all.get(index-1) != arr[i]) {
                all.add(arr[i]);
                index++;
            }
        }

        int[] answer = new int[index];
        for(int i=0; i<answer.length; i++) {
            answer[i] = all.get(i);
        }
        return answer;
    }
}
