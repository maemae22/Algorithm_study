package Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindKim {
    // 배열 원소 하나씩 보면서 찾기 (7ms)
    public String solution(String[] seoul) {
        int index = 0;
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        return "김서방은 "+index+"에 있다";
    }

    // List에 넣어서 indexOf 메서드로 찾기 (7ms)
    public String solution2(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 "+index+"에 있다";
    }

    // Map에 넣어서 Key값으로 찾기 (7ms)
    public String solution3(String[] seoul) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < seoul.length; i++) {
            map.put(seoul[i], i);
        }
        int index = map.get("Kim");

        return "김서방은 "+index+"에 있다";
    }
}
