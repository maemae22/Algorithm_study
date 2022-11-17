package Level0;

public class Babbling1 {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            str = str.replace("aya", "X");
            str = str.replace("ye", "X");
            str = str.replace("woo", "X");
            str = str.replace("ma", "X");

            if(str.equals("X") || str.equals("XX") || str.equals("XXX") || str.equals("XXXX")) {
                answer++;
            }
        }
        return answer;
    }

    public int solution2(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            str = str.replace("aya", "X");
            str = str.replace("ye", "X");
            str = str.replace("woo", "X");
            str = str.replace("ma", "X");
            str = str.replace("X", "");

            if(str.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}
