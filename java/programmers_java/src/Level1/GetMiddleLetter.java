package Level1;

public class GetMiddleLetter {
    public String solution(String s) {
        int length = s.length();
        if(length%2==0) {
            return s.substring(length/2-1, length/2+1);
        } else {
            return String.valueOf(s.charAt(length/2));
        }
    }
}
