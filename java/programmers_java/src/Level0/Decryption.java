package Level0;

public class Decryption {
    public static String solution(String cipher, int code) {
        // 방법1 : 이게 더 빠름
        /*
        String[] str = cipher.split("");
        String[] answerArr = new String[cipher.length()/code];
        int num = 0;
        for(int i=1; i<=str.length; i++) {
            if(i%code==0) {
                answerArr[num] = str[i-1];
                num++;
            }
        }
        return String.join("", answerArr);
        */

        // 방법 2 : 느림
        String answer = "";
        for(int i=1; i<=cipher.length(); i++) {
            if(i%code==0) {
                answer+= cipher.charAt(i-1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("dfjardstddetckdaccccdegk", 4));
    }
}
