package Level1;

public class Lv1_최대공약수와최소공배수 {

    public int[] solution(int n, int m) {

        int max = 0;

        if(n<=m) {
            for(int i=1; i<=m; i++) {
                if(n%i==0 && m%i==0) {
                    max = i;
                }
            }
        } else {
            for(int i=1; i<=n; i++) {
                if(n%i==0 && m%i==0) {
                    max = i;
                }
            }
        }

        int min = n*m/max;

        int[] answer = {max, min};
        return answer;
    }
}
