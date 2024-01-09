package 코딩테스트;

import java.util.*;

public class 코딩테스트1 {

    int[][] solution(int n, int[][] signs) {
        int N = signs.length;
        int[][] answer = new int[N][N];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(signs[i][j]==1) {
                    list.get(i).add(j);
                }
            }
        }

        for(int i=0; i<N; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()) {
                int size = q.size();
                for(int j=0; j<size; j++) {
                    int tmp = q.poll();
                    for(int next : list.get(tmp)) {
                        if(answer[i][next]==0) {
                            answer[i][next]=1;
                            q.offer(next);
                        }
                    }
                }
            }
        }

        return answer;
    }
}
