package Level0;

public class UppercaseAndLowercase {
    public String solution(String my_string) {
        char[] charArr = my_string.toCharArray();

        for(int i=0; i<charArr.length; i++) {
            if('a'<= charArr[i] && charArr[i] <= 'z') { // 소문자이면
                charArr[i] = (char) (charArr[i] -32);
            } else { // 대문자이면
                charArr[i] = (char) (charArr[i]+32) ;
            }
        }
        return new String(charArr);
    }
}
