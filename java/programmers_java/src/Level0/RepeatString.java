package Level0;

public class RepeatString {

    public String solution(String my_string, int n) {
        // 방법1(1.5ms)
        /*
        String[] splitArr = my_string.split("");
        String answer = "";
        for(int i=0 ; i<splitArr.length; i++) {
            for(int j=0 ; j<n; j++) {
                answer += splitArr[i];
            }
        }
        return answer;
        */

        // 방법2 (0.2ms)
        String[] splitArr = my_string.split("");
        for(int i=0 ; i<splitArr.length; i++) {
            splitArr[i] = splitArr[i].repeat(n);
        }
        String answer = String.join("", splitArr);
        return answer;
    }

}
