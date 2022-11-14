package Level0;

import java.util.Arrays;

public class Parallel {

    static public int solution(int[][] dots) {

        if (cal(dots[0], dots[1]) == cal(dots[2], dots[3])
            || cal(dots[0], dots[2]) == cal(dots[1], dots[3])
            || cal(dots[0], dots[3]) == cal(dots[1], dots[2]) ) {
//            System.out.println(cal(dots[0], dots[1]) == cal(dots[2], dots[3]));
//            System.out.println(cal(dots[0], dots[2]) == cal(dots[1], dots[3]));
//            System.out.println(cal(dots[0], dots[3]) == cal(dots[2], dots[1]));

            return 1;
        }
        return 0;
    }

    static public double cal(int[] dot1, int[] dot2) {
        int up = dot1[0] - dot2[0];
        int down = dot1[1] - dot2[1];

//        System.out.println(Arrays.toString(dot1));
//        System.out.println(Arrays.toString(dot2));
//        System.out.println(up);
//        System.out.println(down);
//        System.out.println((double)up/down);

        return (double)up/down;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3, 5}, {4, 1}, {2, 4}, {5, 10}}));
    }
}
