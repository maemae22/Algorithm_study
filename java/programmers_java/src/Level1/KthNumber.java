package Level1;

import java.util.*;

// 레벨1 - K번째수
public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<answer.length; i++) {
            answer[i] = sol(array, commands[i]);
        }
        return answer;
    }

    public int sol(int[] array, int[] ijk) {
        int i = ijk[0];
        int j = ijk[1];
        int k = ijk[2];

        int[] arr = new int[j-i+1];

        //System.arraycopy(array, i - 1 + 0, arr, 0, arr.length);
        for(int m=0; m<arr.length; m++) {
            arr[m] = array[i-1+m];
        }
        Arrays.sort(arr);

        return arr[k-1];
    }


    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
