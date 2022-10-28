package Level0;

public class Factorial {
    public int solution(int n) {
        // 방법1 : 팩토리얼 함수 따로 만들어서 풀기
        /*
        int answer = 1;
        while(true) {
            if(!(fact(answer)<=n)) {
                return answer-1;
            }
            answer++;
        }
    }

    public int fact(int n) {
        int answer = 1;
        for(int i=1; i<=n; i++) {
            answer *= i;
        }
        return answer;
    }
    */

        // 방법2
        int fac =1;
        int i = 1;

        while(true) {
            if(fac>n) {
                return i-2;
            }
            fac *= i;
            i++;
        }

    }
}
