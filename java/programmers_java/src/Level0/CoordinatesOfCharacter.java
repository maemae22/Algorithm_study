package Level0;

public class CoordinatesOfCharacter {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;

        int halfLength = board[0]/2;
        int halfHeight = board[1]/2;

        for(String tmp : keyinput) {
            if(tmp.equals("up")) {
                if(y<halfHeight) y++;
            } else if(tmp.equals("down")) {
                if(y>-halfHeight) y--;
            } else if(tmp.equals("left")) {
                if(x>-halfLength) x--;
            } else if(tmp.equals("right")) {
                if(x<halfLength) x++;
            }
        }

        return new int[] {x, y};
    }
}
