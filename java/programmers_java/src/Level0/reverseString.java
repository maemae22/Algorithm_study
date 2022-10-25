package Level0;

public class reverseString {

    public static String solution(String my_string) {
        String[] strArr = my_string.split("");
        String answer = "";
        for(int i = 0; i<strArr.length; i++) {
            answer += strArr[strArr.length-(i+1)];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("jaron"));
    }
}
