import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14zIwqAHwCFAYD
public class P1230_암호문3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase=1; testCase<=10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new LinkedList<>();
            for (int i=0; i<N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String tmp = st.nextToken();
                if (tmp.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i=0; i<y; i++) {
                        list.add(x+i, Integer.parseInt(st.nextToken()));
                    }
                } else if (tmp.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i=0; i<y; i++) {
                        list.remove(x);
                    }
                } else { // status == "A"
                    int y = Integer.parseInt(st.nextToken());
                    for (int i=0; i<y; i++) {
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }

            System.out.print("#"+testCase);
            for (int i=0; i<10; i++) {
                System.out.print(" "+list.get(i));
            }
            System.out.println();
        }
    }
}
