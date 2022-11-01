package Level1;

public class RemainderIs1 {
    public int solution(int n) {
        /*
        for(int i=1; i<=n; i++) {
            if(n%i ==1) {
                return i;
            }
        }
        return 0;
        */

        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(n%i ==1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
