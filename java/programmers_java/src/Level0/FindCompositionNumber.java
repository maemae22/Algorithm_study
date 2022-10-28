package Level0;

public class FindCompositionNumber {
    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(countDivisor(i)>=3) {
                answer++;
            }
        }
        return answer;
    }

    // 약수의 개수를 구하는 함수
    public static int countDivisor(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(n%i==0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDivisor(10));
        System.out.println(countDivisor(4));
        System.out.println(countDivisor(7));
        System.out.println(solution(10));
        System.out.println(solution(15));
        System.out.println(solution(4));
    }
}
