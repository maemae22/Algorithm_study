package Level0;

public class CountNumber7 {
    public static int solution(int[] array) {
        // 방법1 : 평균 10초 - charAt 사용
        /*
        String total = "";
        for(int num : array) {
            total += num+"";
        }

        int count = 0;
        for(int i=0; i<total.length(); i++) {
            if(total.charAt(i) == '7') {
                count++;
            }
        }
        return count;
        */

        // 방법2 : 평균 10초
        /*
        String total = "";
        for(int num : array) {
            total += num+"";
        }

        String[] str = total.split("");
        int count = 0;
        for(String tmp : str) {
            if(tmp.equals("7")) {
                count++;
            }
        }
        return count;
        */

        // 방법3 : 숫자는 숫자로 처리하자 .... 0.02ms
        int count = 0;
        for(int num : array) {
            while(num>0) {
                if(num%10==7) {
                    count++;
                }
                num /= 10 ;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {7, 77, 17}));
    }
}
