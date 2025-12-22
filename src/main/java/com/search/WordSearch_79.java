package com.search;

import structure.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class WordSearch_79 {
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (dfs(board, word, 0, new boolean[m][n], i, j)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int idx, boolean[][] visited, int x, int y){
        int m = board.length, n = board[0].length;
        if (idx == word.length() - 1) return true;
        visited[x][y] =true;

        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n
                    && word.charAt(idx + 1) == board[nx][ny]
                    && !visited[nx][ny]){
                if (dfs(board, word, idx + 1, visited, nx, ny)) return true;
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
