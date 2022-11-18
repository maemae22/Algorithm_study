package Level1;

public class NumberAndAdditionOfDivisor {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
            if(dirtn(i)%2==0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public int dirtn(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(n%i==0) {
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int left, int right) {
        int answer = 0;

        for (int i=left; i<=right; i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }
        return answer;
    }
}
