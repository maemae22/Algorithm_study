import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18KWf6ItECFAZN
public class S1257_K번째문자열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Set<String> set = new HashSet<>();
            for (int i=0; i<str.length(); i++) {
                for (int j=i+1; j<=str.length(); j++) {
                    set.add(str.substring(i, j));
                }
            }

            if (set.size()<K) {
                System.out.println("#"+testCase+" none");
            } else {
                ArrayList<String> list = new ArrayList<>();
                for (String tmp : set) {
                    list.add(tmp);
                }
                Collections.sort(list);

                System.out.println("#"+testCase+" "+list.get(K-1));
            }
        }
    }
}
