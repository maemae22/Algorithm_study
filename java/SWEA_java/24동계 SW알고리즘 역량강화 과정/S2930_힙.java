import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-Tj7ya3jYDFAXr
public class S2930_힙 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            System.out.print("#"+testCase+" ");
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int query = Integer.parseInt(st.nextToken());
                if (query==1) {
                    q.offer(Integer.parseInt(st.nextToken()));
                } else if (query==2) {
                    if (q.isEmpty()) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(q.poll()+" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] q = new int[N+1];
            int size = 0;
            System.out.print("#"+testCase+" ");
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int query = Integer.parseInt(st.nextToken());
                if (query==1) {
                    int add = Integer.parseInt(st.nextToken());
                    q[++size] = add;
                    int child = size;
                    int parent = child/2;
                    while (parent!=0 && q[parent]<q[child]) {
                        int tmp = q[parent];
                        q[parent] = q[child];
                        q[child] = tmp;

                        child = parent;
                        parent = child/2;
                    }
                } else if (query==2) {
                    if (size==0) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(q[1]+" ");
                        q[1] = q[size--];
                        int parent = 1;
                        int large = parent;
                        while (true) {
                            int left = parent*2;
                            int right = parent*2+1;
                            if (left<=size && q[large]<q[left]) {
                                large = left;
                            }
                            if (right<=size && q[large]<q[right]) {
                                large = right;
                            }
                            if (parent==large) {
                                break;
                            } else {
                                int tmp = q[parent];
                                q[parent] = q[large];
                                q[large] = tmp;
                                parent = large;
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
