package Level1;

public class Lv1_3진법뒤집기 {

    public int solution(int n) {
        int num = n;
        StringBuilder sb = new StringBuilder();
        while(num!=0) {
            sb.append(num%3);
            num = num/3;
        }

        String three = sb.reverse().toString();
        int answer = 0;
        for(int i=0; i<three.length(); i++) {
            answer += Math.pow(3, i) * (three.charAt(i)-48);
        }
        return answer;
    }
}
