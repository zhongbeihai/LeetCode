package com.search;

public class SurroundedRegions_130 {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1},{-1,0}};
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < m; i++){
            if (board[0][i] == 'O') dfs_safe(board, 0 , i);
            if (board[n - 1][i] == 'O') dfs_safe(board, n - 1, i);
        }
        for (int i = 0; i < n; i++){
            if (board[i][0] == 'O') dfs_safe(board, i, 0);
            if (board[i][m - 1] == 'O') dfs_safe(board, i, m - 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public void dfs_safe(char[][] board, int x, int y){
        int n = board.length, m = board[0].length;

        board[x][y] = '#';
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'O'){
                dfs_safe(board, nx, ny);
            }
        }
    }

}
