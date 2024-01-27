import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIfv7qBCYDFAXC
public class S7091_은기의아주큰그림 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] hwnm = new int[4];
            for (int i=0; i<4; i++) {
                hwnm[i] = Integer.parseInt(st.nextToken());
            }
            int[][] small = new int[hwnm[0]][hwnm[1]];
            int[][] big = new int[hwnm[2]][hwnm[3]];
            for (int i=0; i<hwnm[0]; i++) {
                String line = br.readLine();
                for (int j=0; j<hwnm[1]; j++) {
                    if (line.charAt(j)=='o') {
                        small[i][j]=1;
                    } else {
                        small[i][j]=0;
                    }
                }
            }
            for (int i=0; i<hwnm[2]; i++) {
                String line = br.readLine();
                for (int j=0; j<hwnm[3]; j++) {
                    if (line.charAt(j)=='o') {
                        big[i][j]=1;
                    } else {
                        big[i][j]=0;
                    }
                }
            }

            int find[] = convertArr(small);
            int[][] save = new int[hwnm[2]][hwnm[3]];

            for (int i=0; i<hwnm[3]; i++) {
                int sum = 0;
                int power = 0;
                for (int j=0; j<hwnm[0]; j++) {
                    sum += big[j][i]*Math.pow(2, power++);
                }
                save[0][i] = sum;
            }

            for (int i=1; i<=hwnm[2]-hwnm[0]; i++) {
                for (int j=0; j<hwnm[3]; j++) {
                    int tmp = save[i-1][j];
                    tmp -= big[i-1][j];
                    tmp /= 2;
                    tmp += big[i-1+hwnm[0]][j]*Math.pow(2, hwnm[0]-1);
                    save[i][j] = tmp;
                }
            }

            long sumSmall = 0;
            int power = 0;
            for (int k=0; k<hwnm[1]; k++) {
                sumSmall += find[k]*Math.pow(27, power++);
            }

            long[][] sum = new long[hwnm[2]][hwnm[3]];
            for (int i=0; i<=hwnm[2]-hwnm[0]; i++) {
                for (int j=0; j<=hwnm[3]-hwnm[1]; j++) {
                    if (j==0) {
                        long tmp = 0;
                        power = 0;
                        for (int k=0; k<hwnm[1]; k++) {
                            tmp += save[i][k]*Math.pow(27, power++);
                        }
                        sum[i][j] = tmp;
                    } else {
                        sum[i][j] = sum[i][j-1];
                        sum[i][j] -= save[i][j-1];
                        sum[i][j] /= 27;
                        sum[i][j] += save[i][j-1+hwnm[1]]*Math.pow(27, hwnm[1]-1);
                    }
                }
            }

            int answer = 0;
            for (int i=0; i<=hwnm[2]-hwnm[0]; i++) {
                for (int j=0; j<=hwnm[3]-hwnm[1]; j++) {
                    if (sumSmall==sum[i][j]) {
                        answer++;
                    }
                }
            }

            System.out.println("#"+testCase+" "+answer);
        }
    }

    public static int[] convertArr(int[][] small) {
        int[] answer = new int[small[0].length];
        for (int i=0; i<answer.length; i++) {
            int sum = 0;
            int power = 0;
            for (int j=0; j<small.length; j++) {
                sum += small[j][i]*Math.pow(2, power++);
            }
            answer[i]=sum;
        }
        return answer;
    }
}
