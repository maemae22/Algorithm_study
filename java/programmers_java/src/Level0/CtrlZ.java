package Level0;

import java.util.StringTokenizer;

public class CtrlZ {
    static public int solution(String s) {
        String[] arr = s.split(" ");

        int countz = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("Z")) {
                if(countz == 0) {
                    countz++;
                } else {
                    countz += 2;
                }

                arr[i] = "no";
                if(i-countz>=0) {
                    arr[i-countz] = "no";
                }
            } else {
                countz = 0;
            }
        }

        // 남은 숫자만 더해줌
        int sum = 0;
        for (String str : arr) {
            if( ! (str.equals("no")) ) {
                sum += Integer.parseInt(str);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String example1 = "1 2 Z 3";
        String example2 = "2 8 4 7 Z Z 0 1 2 4";
        String example3 = "Z Z 20 Z 1";

        System.out.println(solution(example1));
        System.out.println(solution(example2));
        System.out.println(solution(example3));

    }

    // 프로그래머스 최대한님 코드 (풀이2)
    public int solution2(String s) {
        StringTokenizer st = new StringTokenizer(s);

        int token_cnt = st.countTokens();
        String[] arr1 = new String[token_cnt];

        for(int i=0; i<token_cnt; i++){
            arr1[i]=st.nextToken();
        }

        int ans=0;
        int z_cnt=0;

        for(int i=0; i<token_cnt; i++){
            if(arr1[i].equals("Z")){
                if(z_cnt !=0) { z_cnt +=2; }
                else z_cnt++;
                if(i<z_cnt) continue;
                ans -= Integer.parseInt(arr1[i-z_cnt]);

            } else {
                ans += Integer.parseInt(arr1[i]);
                z_cnt=0;
            }

        }

        return ans;
    }
}
