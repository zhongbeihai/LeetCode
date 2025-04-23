package com.search;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class WordSearch_79 {

    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] !=  word.charAt(0)) continue;
                if (dfs(board, word, new int[]{i, j})) return true;
            }
        }

        return false;
    }

    // 1 -> visiting, 2 -> visited
    public boolean dfs(char[][] board, String word, int[] startPoint){
        int x = startPoint[0], y = startPoint[1], p = startPoint[2];
        if (p == word.length()) return true;

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || board[x][y] != word.charAt(p)) return false;

        char tem = board[x][y];
        board[x][y] = '#';

        boolean found = dfs(board, word, new int[]{x + 1, y, p+ 1}) || // 下
                dfs(board, word, new int[]{x-1, y, p + 1}) || // 上
                dfs(board, word, new int[]{x, y + 1, p + 1}) || // 右
                dfs(board, word, new int[]{x, y - 1, p + 1});

        board[x][y] = tem;
        return found;
    }

    public static void main(String[] args) {
        WordSearch_79 w = new WordSearch_79();
        w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
    }
}
