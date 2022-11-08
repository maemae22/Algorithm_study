package Level2;

import java.util.Arrays;

public class MaxAndMin {
    static public String solution(String s) {
        String[] arr = s.split(" ");
        int[] intArr = new int[arr.length];
        int index = 0;
        for(String tmp : arr) {
            intArr[index] = Integer.parseInt(tmp);
            index++;
        }

        Arrays.sort(intArr);

        return intArr[0]+" "+intArr[intArr.length-1];
    }

    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }
}
