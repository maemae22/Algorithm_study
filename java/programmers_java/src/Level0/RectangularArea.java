package Level0;

public class RectangularArea {
    public int solution(int[][] dots) {
        int down = 0;
        int up = 0;

        int x = dots[0][0];
        int y = dots[0][1];

        for(int i=1; i<dots.length; i++) {
            if(dots[i][0] == x) {
                up = Math.abs(dots[i][1] - y);
            }
        }

        for(int i=1; i<dots.length; i++) {
            if(dots[i][1] == y) {
                down = Math.abs(dots[i][0] -x);
            }
        }

        return down * up;
    }
}
