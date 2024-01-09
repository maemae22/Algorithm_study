import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// No. 1 [사전 문제] 삼각김밥 월드
public class 삼각김밥월드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[150];
        arr[1]=1;
        for (int i=2; i<150; i++) {
            arr[i] = arr[i-1]+(i-1);
        }

        for (int testCase=1; testCase<=N; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (s>e) {
                int tmp = s;
                s = e;
                e = tmp;
            }
            int answer = 0;
            if (s!=e) {
                int[] sArr = findXY(arr, s);
                int[] eArr = findXY(arr, e);
                int height = Math.abs(sArr[0]-eArr[0]);
                answer += height;

                if (!(sArr[1]<=eArr[1] && eArr[1]<=sArr[1]+height)) {
                    if (eArr[1]<sArr[1]) {
                        answer += Math.abs(sArr[1]-eArr[1]);
                    } else {
                        answer += Math.abs(eArr[1]-(sArr[1]+height));
                    }
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    public static int[] findXY(int[] arr, int target) {
        int[] answer = new int[2];
        int lt = 0;
        int rt = arr.length;
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (arr[mid]<=target) {
                lt = mid+1;
                answer[0]=mid;
            } else {
                rt = mid-1;
            }
        }

        answer[1] = target-arr[answer[0]];
        return answer;
    }
}
