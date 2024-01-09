package 코딩테스트;

import java.util.*;

public class 코딩테스트3 {

    public int solution(int n, int[][] groups) {
        int answer = 0;
        ArrayList<Task> list = new ArrayList<>();
        for(int i=0; i<groups.length; i++) {
            list.add(new Task(groups[i][0], groups[i][1]));
        }
        Collections.sort(list);

        int j=0;
        int end = 1;
        for(int i=1; i<=n; i++) {
            if(j<list.size() && i<list.get(j).start) {
                answer++;
                end = i;
            } else if(j<list.size()) {
                int max = end;
                boolean pick = false;
                while(j<list.size() && list.get(j).start<=end+1) {
                    if(end<list.get(j).end) {
                        max = Math.max(max, list.get(j).end);
                        pick = true;
                    }
                    j++;
                }
                if(pick) {
                    answer++;
                    i=max;
                    end=max;
                } else {
                    answer++;
                    end = i;
                }
            } else {
                answer++;
                end=i;
            }
        }
        return answer;
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;
    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Task o) {
        return this.start!=o.start ? this.start-o.start : o.end-this.end;
    }
}
