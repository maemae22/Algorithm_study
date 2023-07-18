import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXRSXf_a9qsDFAXS
public class P10726_이진수표현 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            String answer = "ON";
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String twoNum = Integer.toBinaryString(M);
//            System.out.println(twoNum);

            if (twoNum.length()<N) {
                answer = "OFF";
            } else {
                String check = twoNum.substring(twoNum.length()-N);
                for (char c : check.toCharArray()) {
                    if (c!='1') {
                        answer = "OFF";
                        break;
                    }
                }
            }
            System.out.println("#"+testCase+" "+answer);
        }
    }
}
