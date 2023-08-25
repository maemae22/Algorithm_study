import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqU0zh6rssDFARG
public class P7701_염라대왕의이름정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            TreeSet<Name> set = new TreeSet<>();
            for (int i=0; i<N; i++) {
                set.add(new Name(br.readLine()));
            }
            System.out.println("#"+testCase);
            for (Name tmp : set) {
                System.out.println(tmp.name);
            }
        }
    }
}

class Name implements Comparable<Name> {
    String name;
    Name(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Name o) {
        return o.name.length()==this.name.length() ? this.name.compareTo(o.name) : this.name.length()-o.name.length();
    }
}
