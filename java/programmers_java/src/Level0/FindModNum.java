package Level0;

import java.util.*;

public class FindModNum {
    static public int solution(int[] array) {
        Map<Integer, Integer> all = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (all.containsKey(array[i])) {
                all.put(array[i], all.get(array[i])+1);
            } else {
                all.put(array[i], 1);
            }
        }

        int max = Collections.max(all.values());
        List<Integer> keyList = new ArrayList<>();

        for (int key : all.keySet() ) {
            if(all.get(key) == max) {
                keyList.add(key);
            }
        }

        if(keyList.size()==1) {
            return keyList.get(0);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 3, 3, 4}));
    }
}
