package Level1;

import java.util.*;

// 레벨1 - 두 개 뽑아서 더하기
public class PickTwoAndAdd {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int index = 0;
        for(int tmp : set) {
            answer[index] = tmp;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
