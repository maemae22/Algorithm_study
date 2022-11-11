package Level0;

public class OXQuiz {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for(int i=0; i<answer.length; i++) {
            answer[i] = calculate(quiz[i]);
        }

        return answer;
    }

    public String calculate(String quiz) {
        String[] split = quiz.split(" ");

        if(split[1].equals("+")) {
            if(Integer.parseInt(split[0])+Integer.parseInt(split[2]) == Integer.parseInt(split[4])) {
                return "O";
            } else {
                return "X";
            }
        } else {
            if(Integer.parseInt(split[0])-Integer.parseInt(split[2]) == Integer.parseInt(split[4])) {
                return "O";
            } else {
                return "X";
            }
        }
    }


    public String[] solution2(String[] quiz) {
        for(int i=0; i<quiz.length; i++){
            String[] text = quiz[i].split(" ");
            int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) );
            quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
        }
        return quiz;
    }
}
