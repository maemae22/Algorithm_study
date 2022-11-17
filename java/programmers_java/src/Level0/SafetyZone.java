package Level0;

import java.util.*;

public class SafetyZone {
    public int solution(int[][] board) {
        int length = board.length;
        int last = board.length-1;

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                if(board[i][j] == 1) {
                    if(i!=0 && j!=0 && board[i-1][j-1]!=1) {
                        board[i-1][j-1] = 2;
                    }
                    if (i!=0 && board[i-1][j]!=1) {
                        board[i-1][j] = 2;
                    }
                    if (i!=0 && j!=last && board[i-1][j+1]!=1) {
                        board[i-1][j+1] = 2;
                    }
                    if (j!=0 && board[i][j-1]!=1) {
                        board[i][j-1] = 2;
                    }
                    if (j!=last && board[i][j+1]!=1) {
                        board[i][j+1] = 2;
                    }
                    if (i!=last && j!=0 && board[i+1][j-1]!=1) {
                        board[i+1][j-1] = 2;
                    }
                    if (i!=last && board[i+1][j]!=1) {
                        board[i+1][j] = 2;
                    }
                    if (i!=last && j!=last && board[i+1][j+1]!=1) {
                        board[i+1][j+1] = 2;
                    }
                }
            }
        }

        int count = 0;
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                if(board[i][j] ==0) {
                    count++;
                }
            }
        }

        //System.out.println(Arrays.deepToString(board));
        return count;

    }

}
