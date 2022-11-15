package Level0;

import java.util.Arrays;

public class AddPolynomial {

    static public String solution(String polynomial) {
        String[] split = polynomial.split(" \\+ ");
        //System.out.println(Arrays.toString(split));

        int num = 0;
        int xNum = 0;

        for(int i=0; i<split.length; i++) {
            if(split[i].contains("x")) {
                if(split[i].equals("x")) {
                    xNum++;
                } else if(split[i].equals("-x")) {
                    xNum--;
                } else {
                    xNum += Integer.parseInt(split[i].substring(0, split[i].length()-1));
                }

            } else {
                num += Integer.parseInt(split[i]);
            }
        }

        // 출력
        String answer = "";
        if (xNum!=0 && xNum!=1 && xNum!=-1) {
            answer += xNum+"x";
        } else if (xNum == 1) {
            answer += "x";
        } else if (xNum == -1) {
            answer += "-x";
        }

        if(!answer.equals("") && num!=0) {
            answer += " + " + num;
        } else if (num!=0) {
            answer += num;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("3x + 7 + x"));
        System.out.println(solution("x + x + x"));
    }
}
