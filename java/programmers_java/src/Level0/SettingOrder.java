package Level0;

import java.util.*;

public class SettingOrder {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        //int[] copy = Arrays.copyOf(emergency, emergency.length);
        //int[] copy = emergency.clone();
        List<Integer> copy = new ArrayList<>();
        for(int tmp : emergency) {
            copy.add(tmp);
        }
        //Collections.sort(copy, Collections.reverseOrder());
        copy.sort(Collections.reverseOrder());

        for(int i=0; i<emergency.length; i++) {
            answer[i] = copy.indexOf(emergency[i]) + 1;
        }


        return answer;

    }
}
