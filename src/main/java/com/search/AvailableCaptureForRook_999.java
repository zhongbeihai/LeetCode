package com.search;

public class AvailableCaptureForRook_999 {
    public int numRookCaptures(char[][] board) {
        int[][] directions = new int[][]{{1,0}, {-1, 0},{0,1},{0,-1}};

        int x = 0, y = 0;
        for(int j= 0; j < board.length; j++){
            for(int i = 0; i < board[0].length; i++){
                if(board[j][i] == 'R'){
                    x = j;
                    y = i;
                }
            }
        }
        int count = 0;
        for(int[] dir: directions){
            int nx = x + dir[0], ny = y + dir[1];
            while (nx >= 0 && nx < board.length &&
            ny >= 0 && ny< board[0].length && board[nx][ny] == '.'){
                nx += dir[0];
                ny += dir[1];
            }
            if(nx >= 0 && nx < board.length &&
                    ny >= 0 && ny< board[0].length && board[nx][ny] == 'p') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        AvailableCaptureForRook_999 a = new AvailableCaptureForRook_999();
        a.numRookCaptures(new char[][]{{'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'}, {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}});
    }
}
