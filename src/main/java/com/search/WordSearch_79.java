package com.search;

import structure.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class WordSearch_79 {
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, new boolean[n][m], i, j)) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int idx, boolean[][] visited, int x, int y){
        int n = board.length, m = board[0].length;

        if (idx == word.length() - 1) return true;
        visited[x][y] = true;
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == word.charAt(idx + 1) && !visited[nx][ny]){
                if( dfs(board, word, idx + 1, visited, nx, ny)) return true;
            }
        }

        visited[x][y] = false;
        return false;
    }


    public static void main(String[] args) {
        WordSearch_79 w = new WordSearch_79();
        //w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
        w.exist(new char[][]{{'C', 'A','A'}, {'A', 'A','A'}, {'B','C','D'}}, "AAB");
    }
}
