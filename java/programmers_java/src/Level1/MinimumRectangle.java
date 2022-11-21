package Level1;

import java.util.*;

// 레벨1 - 최소직사각형
public class MinimumRectangle {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;

        for(int[] arr : sizes) {
            Arrays.sort(arr);
            if(arr[0] > max1) {
                max1 = arr[0];
            }
            if(arr[1] > max2) {
                max2 = arr[1];
            }
        }
        return max1 * max2;
    }
}
