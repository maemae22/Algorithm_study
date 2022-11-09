package Level0;
import java.util.*;

public class AppearedOnce {

    // 15~20초
    static public String solution(String s) {

        int[] allChar = new int[26];
        List<Character> once = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            allChar[(int)tmp-97]++;
        }

        for (int i = 0; i < allChar.length; i++) {
            if(allChar[i] == 1) {
                once.add((char)(97+i));
            }
        }

        Collections.sort(once);

        String answer = "";
        for ( char tmp : once ) {
            answer += tmp;
        }

        return answer;
    }

    static public String solution2(String s) {

        int[] allChar = new int[26];

        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            allChar[(int)tmp-97]++;
        }

        String answer = "";
        for (int i = 0; i < allChar.length; i++) {
            if(allChar[i] == 1) {
                answer += (char)(97+i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcadc"));
        System.out.println(solution("abdc"));
        System.out.println(solution("hello"));
    }
}
