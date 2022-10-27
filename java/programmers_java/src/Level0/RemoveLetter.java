package Level0;

public class RemoveLetter {
    public String solution(String my_string, String letter) {
        /*
        String[] str = my_string.split("");

        String answer="";
        for(String string : str) {
            if(!string.equals(letter)) {
                answer += string;
            }
        }
        return answer;
        */

        return my_string.replace(letter, "");
    }
}
