import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// No. 2 [사전 문제] AI의 반란 최후의 전쟁
public class AI의반란최후의전쟁 {

    static int[] check;
    static int answer;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=1; testCase<=T; testCase++) {
            N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][3];
            int[][] add = new int[N][5];
            int tmpAnswer = 0;
            int[] tmpCheck = new int[3];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
                add[i][0] = arr[i][1]+arr[i][2];
                add[i][1] = arr[i][0]+arr[i][2];
                add[i][2] = arr[i][0]+arr[i][1];
                int[] tmp = findMin(add[i]);
                tmpAnswer += tmp[0];
                tmpCheck[tmp[1]]++;
                add[i][3] = tmp[0]; // 최소 값 (min)
                add[i][4] = tmp[1]; // 최소 Index
            }

            if (N<3) {
                System.out.println("#"+testCase+" "+"-1");
            } else if (tmpCheck[0]>=1 && tmpCheck[1]>=1 && tmpCheck[2]>=1) {
                System.out.println("#"+testCase+" "+tmpAnswer);
            } else {
                List<Integer> count = new ArrayList<>();
                for (int i=0; i<3; i++) {
                    if (tmpCheck[i]==0) {
                        count.add(i);
                    }
                }

                if (count.size()==1) {
                    int needIndex = count.get(0);
                    List<Add> list = new ArrayList<>();
                    for (int i=0; i<N; i++) {
                        list.add(new Add(add[i][needIndex]-add[i][3], add[i][4]));
                    }
                    Collections.sort(list);

                    if (tmpCheck[list.get(0).minIndex]>=2) {
                        tmpAnswer += list.get(0).diff;
                        System.out.println("#"+testCase+" "+tmpAnswer);
                    } else { // tmpCheck[list.get(0).minIndex]==1
                        check = new int[3];
                        answer = Integer.MAX_VALUE;
                        DFS(0, 0, add);
                        System.out.println("#"+testCase+" "+answer);
                    }
                } else { // count.size()==2
                    int need1 = count.get(0);
                    int need2 = count.get(1);
                    int[][] needs = new int[N][2];
                    for (int i=0; i<N; i++) {
                        needs[i][0] = add[i][need1]-add[i][3];
                        needs[i][1] = add[i][need2]-add[i][3];
                    }
                    int needAdd = Integer.MAX_VALUE;
                    for (int i=0; i<N; i++) {
                        for (int j=0; j<N; j++) {
                            if (i!=j) {
                                needAdd = Math.min(needAdd, needs[i][0]+needs[j][1]);
                            }
                        }
                    }
                    tmpAnswer += needAdd;
                    System.out.println("#"+testCase+" "+tmpAnswer);
                }
            }
        }
    }

    public static void DFS(int index, int sum, int[][] add) {
        if (sum>=answer) {
            return;
        }
        if (index==N) {
            if (check[0]>=1 && check[1]>=1 && check[2]>=1) {
                answer = Math.min(answer, sum);
            }
        } else {
            for (int i=0; i<3; i++) {
                check[i]++;
                DFS(index+1, sum+add[index][i], add);
                check[i]--;
            }
        }
    }

    public static int[] findMin(int[] arr) {
        int min = arr[0];
        int minIndex = 0;
        for (int i=1; i<3; i++) {
            if (arr[i]<min) {
                min = arr[i];
                minIndex = i;
            }
        }

        return new int[]{min, minIndex};
    }
}

class Add implements Comparable<Add> {
    int diff;
    int minIndex;
    Add(int diff, int minIndex) {
        this.diff = diff;
        this.minIndex = minIndex;
    }
    @Override
    public int compareTo(Add o) {
        return this.diff - o.diff;
    }
}
