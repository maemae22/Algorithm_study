package Level0;

public class RemoveDuplicateCharacters {
    public String solution(String my_string) {
        String answer = "";

        String[] str = my_string.split("");
        for(String tmp : str) {
            if(!(answer.contains(tmp))) {
                answer += tmp;
            }
        }

        return answer;
    }
}
