package Level1;

import java.util.*;

public class DivisiveArray {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> div = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor == 0) {
                div.add(arr[i]);
            }
        }

        if(div.size()==0) {
            return new int[] {-1};
        } else {
            int[] answer = new int[div.size()];
            for(int i=0; i<div.size(); i++) {
                answer[i] = div.get(i);
            }

            Arrays.sort(answer);
            return answer;
        }
    }
}
