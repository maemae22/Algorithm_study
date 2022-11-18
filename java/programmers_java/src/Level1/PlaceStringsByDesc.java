package Level1;

import java.util.*;

public class PlaceStringsByDesc {
    public String solution(String s) {
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        return String.join("", str);
    }
}
