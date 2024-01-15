import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDN86AAXw5UW6&subjectId=AWOVJ1r6qfkDFAWg
public class S5122_수열편집 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int i=0; i<3; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new LinkedList<>();
            for (int i=0; i<arr[0]; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            for (int i=0; i<arr[1]; i++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int index = Integer.parseInt(st.nextToken());
                if (c=='I') {
                    list.add(index, Integer.parseInt(st.nextToken()));
                } else if (c=='D') {
                    list.remove(index);
                } else if (c=='C') {
                    list.remove(index);
                    list.add(index, Integer.parseInt(st.nextToken()));
                }
            }

            int answer = arr[2]<list.size() ? list.get(arr[2]) : -1;
            System.out.println("#"+testCase+" "+answer);
        }
    }
}
