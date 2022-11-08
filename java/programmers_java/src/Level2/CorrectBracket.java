package Level2;

public class CorrectBracket {
    static boolean solution(String s) {
        /*
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
        */

        if(s.charAt(0) == ')') return false;
        int open = 0;
        int close = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') open ++;
            else close++;
            if(open < close) return false;
        }

        return open == close ;

    }

    public static void main(String[] args) {
        System.out.println(solution("(()))("));
    }
}
