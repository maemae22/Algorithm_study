import java.util.*;
import java.io.*;

// https://softeer.ai/practice/info.do?idx=1&eid=1717
public class 자동차테스트 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<N; i++) {
            map.put(arr[i], i+1);
        }

        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(br.readLine());
            if(map.containsKey(target)) {
                int index = map.get(target);
                // System.out.println("index = "+index);
                System.out.println((index-1)*(N-index));
            } else {
                System.out.println(0);
            }
        }
    }
}
