package Level0;

import java.util.Arrays;

public class MakeBWithA {
    public int solution(String before, String after) {
        String[] beforeStr = before.split("");
        String[] afterStr = after.split("");

        Arrays.sort(beforeStr);
        Arrays.sort(afterStr);

        // 방법1 : Arrays.equals 메서드를 이용한 배열의 비교
        /*
        if(Arrays.equals(beforeStr, afterStr)) {
            return 1;
        } else {
            return 0;
        }
        */

        // 방법2 : for문 이용
        for(int i=0; i<beforeStr.length; i++) {
            if(!beforeStr[i].equals(afterStr[i])) {
                return 0;
            }
        }
        return 1;

    }
}
