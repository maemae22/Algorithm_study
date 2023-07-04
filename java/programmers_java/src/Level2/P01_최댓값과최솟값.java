package Level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class P01_최댓값과최솟값 {

    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        return list.get(0)+" "+list.get(list.size()-1);
    }
}
