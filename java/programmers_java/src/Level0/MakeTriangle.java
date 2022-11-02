package Level0;

import java.util.*;

public class MakeTriangle {
    public static int solution(int[] sides) {
        Arrays.sort(sides);

        Set<Integer> answer = new HashSet<>();
        // sides[1]이 가장 긴 변일 때,
        for(int i=1; i<=sides[1]; i++) {
            if(sides[0]+i > sides[1]) {
                answer.add(i);
            }
        }

        // 추가되는 변의 길이가 가장 긴 변일 때,
        for(int j=sides[1]; ; j++) {
            if(!(sides[0] + sides[1] > j)) {
                break;
            }
            answer.add(j);
        }

        return answer.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 6}));
        System.out.println(solution(new int[] {11, 7}));
    }
}
