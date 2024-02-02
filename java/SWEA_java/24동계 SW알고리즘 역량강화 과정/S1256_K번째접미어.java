import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18GHd6IskCFAZN
public class S1256_K번째접미어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            if (str.length()<K) {
                System.out.println("#"+testCase+" none");
            } else {
                ArrayList<String> list = new ArrayList<>();
                for (int i=0; i<str.length(); i++) {
                    list.add(str.substring(i));
                }
                Collections.sort(list);

                System.out.println("#"+testCase+" "+list.get(K-1));
            }
        }
    }
}
