import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW45TzHae8UDFAQ7
public class P8898_3차원농부 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=1; testCase<=T; testCase++) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            ArrayList<Animal> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine()); // N개의 소들의 위치
            for (int i=0; i<N; i++) {
                list.add(new Animal(1, Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine()); // M개의 말들의 위치
            for (int i=0; i<M; i++) {
                list.add(new Animal(2, Integer.parseInt(st.nextToken())));
            }

            // 로직
            Collections.sort(list);
            int min = Integer.MAX_VALUE;
            int count = 0;
            for (int i=1; i<list.size(); i++) {
                if (list.get(i-1).type!=list.get(i).type) {
                    int len = Math.abs(list.get(i-1).z-list.get(i).z);
                    if (len==min) {
                        count++;
                    } else if (len<min) {
                        min = len;
                        count = 1;
                    }
                }
            }

            System.out.println("#"+testCase+" "+(min+Math.abs(c1-c2))+" "+count);
        }
    }
}

class Animal implements Comparable<Animal> {
    int type; // 소는 1, 말은 2
    int z; // 동물의 z 좌표
    Animal(int type, int z) {
        this.type = type;
        this.z = z;
    }

    @Override
    public int compareTo(Animal o) {
        return this.z - o.z;
    }
}
