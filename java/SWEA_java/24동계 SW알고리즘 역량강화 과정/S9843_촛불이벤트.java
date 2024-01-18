import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXGBKzuaPOoDFAXR
public class S9843_촛불이벤트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            System.out.println("#"+testCase+" "+binarySearch(Long.parseLong(br.readLine())));
        }
    }

    public static long binarySearch(long count) {
        long answer = -1;
        long lt = 0;
        long rt = (long) Math.pow(2*count, 0.5);
        while (lt<=rt) {
            long mid = (lt+rt)/2;
            long need = mid*(mid+1)/2;
            if (need<count) {
                lt = mid+1;
            } else if (count<need) {
                rt = mid-1;
            } else { // count==need
                answer = mid;
                break;
            }
        }

        return answer;
    }
}
