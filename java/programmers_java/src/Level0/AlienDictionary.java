package Level0;

import java.util.*;

public class AlienDictionary {
    public static int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);

        for(String str : dic) {
            String[] tmp = str.split("");
            Arrays.sort(tmp);
            if(Arrays.equals(spell, tmp)) {
                return 1;
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        String[] spell = new String[] {"z", "d", "x"};
        String[] dic = new String[] {"def", "dww", "dzx", "loveaw"};
        System.out.println(solution(spell, dic));
    }
}
