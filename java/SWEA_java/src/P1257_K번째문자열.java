import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18KWf6ItECFAZN
public class P1257_K번째문자열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=1; testCase<=T; testCase++) {
            int K = Integer.parseInt(br.readLine());
            String letter = br.readLine();
            String answer = "none";

            HashSet<String> set = new HashSet<>();
            for (int i=1; i<=letter.length(); i++) {
                for (int j=0; j<letter.length()-i+1; j++) {
                    set.add(letter.substring(j, j+i));
                }
            }

            if (set.size()>=K) {
                ArrayList<String> list = new ArrayList<>();
                for (String tmp : set) {
                    list.add(tmp);
                }
                Collections.sort(list);
                answer = list.get(K-1);
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }
}
