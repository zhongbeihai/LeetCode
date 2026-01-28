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
                if (word.charAt(0) == board[i][j]) {
                    boolean flag = dfs(board, word, new boolean[m][n], 0, i, j);
                    if (flag) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int idx, int x, int y){
        if (idx == word.length() - 1) return true;

        visited[x][y] = true;
        boolean flag = false;
        for (int[] dir: dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                    && !visited[nx][ny] && word.charAt(idx + 1) == board[nx][ny]){
                flag |= dfs(board, word, visited, idx + 1, nx , ny);
            }
        }
        visited[x][y] = false;

        return flag;
    }


    public static void main(String[] args) {
        WordSearch_79 w = new WordSearch_79();
        //w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
        w.exist(new char[][]{{'C', 'A','A'}, {'A', 'A','A'}, {'B','C','D'}}, "AAB");
    }
}
