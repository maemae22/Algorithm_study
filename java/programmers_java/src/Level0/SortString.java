package Level0;

import java.util.Arrays;

public class SortString {
    public String solution(String my_string) {
        // 방법1
        /*
        String lowerStr = my_string.toLowerCase();
        String[] str = lowerStr.split("");
        Arrays.sort(str);
        return String.join("",str);
        */

        // 방법2
        char[] charArr = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
