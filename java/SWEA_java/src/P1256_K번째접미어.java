import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18GHd6IskCFAZN
public class P1256_K번째접미어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int K = Integer.parseInt(br.readLine());
            String letter = br.readLine();

            ArrayList<String> list = new ArrayList<>();
            for (int i=0; i<letter.length(); i++) {
                list.add(letter.substring(i));
            }

            Collections.sort(list);
            System.out.println("#"+testCase+" "+list.get(K-1));
        }
    }
}
