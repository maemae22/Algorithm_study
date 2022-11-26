package Level2;

// 레벨2 - 올바른 괄호 (풀이 추가, 약간의 리팩토링)
public class CorrectBracket {

    // 정확성 테스트 통과O, 효율성 테스트 통과X (시간 초과)
    static boolean solution(String s) {
        String[] str = s.split("");
        int open = 0;
        int close = 0;
        if(str[0].equals(")")) return false;
        for(String tmp : str) {
            if(tmp.equals("(")) {
                open++;
            } else {
                close++;
            }
            if(open < close) return false;
        }
        return open == close ;
    }

    // 정확성 테스트 통과O, 효율성 테스트 통과O
    boolean solution2(String s) {
        if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
            return false;
        }
        int open = 0;
        int close = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            //   (()))(()
            if(open<close) {
                return false;
            }
        }

        return open == close ;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()))("));
    }
}
