package 코딩테스트;

public class 코딩테스트2 {

    public int solution(String s) {
        int answer = 1;
        // 문자열 s에서 i번째 인덱스를 기준으로 만들 수 있는 펠린드롬의 최대 길이를 확인함
        for(int i=0; i<s.length(); i++) {
            // 홀수 길이일 때
            int lt = i-1;
            int rt = i+1;
            answer = Math.max(answer, getMaxLength(s, lt, rt));

            // 짝수 길이일 때
            lt = i;
            rt = i+1;
            answer = Math.max(answer, getMaxLength(s, lt, rt));
        }

        return answer;
    }

    public int getMaxLength(String s, int lt, int rt) {
        while(0<=lt && rt<s.length() && s.charAt(lt)==s.charAt(rt)) {
            lt--;
            rt++;
        }
        lt++;
        rt--;
        return rt-lt+1;
    }
}
