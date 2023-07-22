import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDN86AAXw5UW6&subjectId=AWOVJ1r6qfkDFAWg
public class P5122_수열편집 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> list = new LinkedList<>();
            for (int i=0; i<N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                String status = st.nextToken();
                if (status.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    list.add(x, y);
                } else if (status.equals("D")) {
                    list.remove(Integer.parseInt(st.nextToken()));
                } else { // status == "C"
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    list.remove(x);
                    list.add(x, y);
                }
            }

            int answer = -1;
            if (list.size()>=L+1) {
                answer = list.get(L);
            }
            System.out.println("#"+testCase+" "+answer);
        }

    }
}
