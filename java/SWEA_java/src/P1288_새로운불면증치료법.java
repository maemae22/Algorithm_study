import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18_yw6I9MCFAZN#
public class P1288_새로운불면증치료법 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            int[] arr = new int[10];
            int count = 0;

            for (int i=1; ; i++) {
                long num = N*i;
                for (char c : String.valueOf(num).toCharArray()) {
                    if (arr[(int)c-48]==0) {
                        arr[(int)c-48]++;
                        count++;
//                        System.out.println(num);
                    }
                }
                if (count==10) {
                    answer = num;
                    break;
                }
            }
            System.out.println("#"+testCase+" "+answer);
        }
    }
}
