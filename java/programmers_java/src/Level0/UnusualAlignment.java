package Level0;

import java.util.*;

public class UnusualAlignment {
    public int[] solution(int[] numlist, int n) {
        int[] abs = new int[numlist.length];
        for(int i=0; i<numlist.length; i++) {
            abs[i] = Math.abs(numlist[i] - n);
        }
        int[] sort = abs.clone();
        Arrays.sort(sort);
        //System.out.println(Arrays.toString(sort));

        int[] answer = new int[numlist.length];

        int count = 0;
        int index = 0;
        for(int i=0; i<numlist.length; i++) {
            for(int k=numlist.length-1; k>=0; k--) {
                if(count==0 && sort[i] == abs[k]) {
                    answer[index] = numlist[k];
                    index++;
                    count++;
                } else if (sort[i] == abs[k]) {
                    int add = numlist[k];

                    if(add>answer[index-1]) {
                        int tmp = answer[index-1];
                        answer[index-1] = add;
                        answer[index] = tmp;
                    } else {
                        answer[index] = add;
                    }
                    i++;
                    index++;
                }
            }
            count = 0;
        }

        return answer;

    }
}
