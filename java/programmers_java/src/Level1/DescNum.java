package Level1;

import java.util.*;

public class DescNum {
    public long solution(long n) {
        String[] arr = (n+"").split("");
        Arrays.sort(arr, Collections.reverseOrder());

        String sortNum = String.join("", arr);
        return Long.parseLong(sortNum);
    }
}
