package Level0;

import java.util.List;
import java.util.*;

public class NearNum {
    public int solution(int[] array, int n) {
        List<Integer> list = new ArrayList<>();
        for(int tmp : array) {
            list.add(tmp);
        }
        list.add(n);

        Collections.sort(list);
        int index = list.indexOf(n);

        if(index==0) {
            return list.get(1);
        } else if(index== list.size()-1) {
            return list.get(list.size()-2);
        } else {

            int num1 = list.get(index-1);
            int num2 = list.get(index+1);

            if(n-num1 == num2-n) {
                return num1;
            } else if(n-num1<num2-n) {
                return num1;
            } else {
                return num2;
            }

        }
    }
}
