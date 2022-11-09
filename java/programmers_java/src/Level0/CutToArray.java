package Level0;

public class CutToArray {
    public String[] solution(String my_str, int n) {
        int index = 0;
        if(my_str.length()%n ==0) {
            index = my_str.length()/n;
        } else {
            index = my_str.length()/n + 1;
        }
        String[] answer = new String[index];
        int start = 0;

        for(int i=0; i<answer.length -1; i++) {
            answer[i] = my_str.substring(start, start+n);
            start += n;
        }
        answer[answer.length-1] = my_str.substring(start);

        return answer;

    }

    public String[] solution2(String my_str, int n) {
        int resultCnt = (my_str.length() + n - 1) / n;
        String[] answer = new String[resultCnt];

        for (int i = 0; i < resultCnt; i++) {
            int start = n * i;
            //int end = start + n >= my_str.length()? my_str.length(): start + n;
            int end = Math.min(start + n, my_str.length());

            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }
}
