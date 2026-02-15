package com.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix_329 {
    private int[][] memo;
    private int[][] dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }

        return res;
    }

    public int dfs(int[][] matrix, int x, int y){
        if (memo[x][y] != 0) return memo[x][y];

        int cur = 0;
        for (int[] dir : dirs){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[nx][ny] > matrix[x][y]){
                cur = Math.max(cur, dfs(matrix, nx, ny));
            }
        }

        memo[x][y] = cur + 1;
        return memo[x][y];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix_329 l = new LongestIncreasingPathInAMatrix_329();
        l.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}});
    }
}
