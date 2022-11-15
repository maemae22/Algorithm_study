package Level0;

public class CountKNum {
    public static int solution(int i, int j, int k) {
        // 방법1 : programmers 다른 사람 풀이 참고
        int count = 0;
        for(int t=i; t<=j; t++) {
            int tmp = t;
            while(tmp>0) {
                if(tmp%10 == k) {
                    count++;
                }
                tmp /= 10;
            }
        }
        return count;


        // 방법1-실패
        /*
        int count = 0;
        for(int t=i; t<=j; t++) {
            while(t>0) {
                if(t%10 == k) {
                    count++;
                }
                t /= 10;
            }
        }
        return count;
         */


        /* 방법2 : 시간이 어마어마하게 길게 걸린다.....
        String str = "";
        for(int t=i; t<=j; t++) {
            str += t+"";
        }
        String[] arr = str.split("");

        int count = 0;
        for (String tmp : arr) {
            if(tmp.equals(k+"")) {
                count++;
            }
        }
        return count;
        */


        // 실패 풀이 : int로 parsing하면 범위 초과 exception (NumberFormatException 발생)
        /*
        double totalStr = Double.parseDouble(str);

        int count = 0;
        while(totalStr>0) {
            if(totalStr % 10 == k) {
                count++;
            }
            totalStr /= 10;
        }
        return count;
        */
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 13, 1));
    }
}
