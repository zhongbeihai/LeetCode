package com.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix_329 {
    private int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        int maxx = -1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(dp[i][j] == -1){
                    maxx = Math.max(maxx, dfs(matrix, i, j));
                }
            }
        }

        return maxx;
    }

    public int dfs(int[][] matrix, int r, int c){
        if(dp[r][c] != -1) return dp[r][c];

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int maxx = 1;
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]){
                maxx = Math.max(maxx, dfs(matrix, nr, nc));
            }
        }
        dp[r][c] = maxx;
        return maxx;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix_329 l = new LongestIncreasingPathInAMatrix_329();
        l.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}});
    }
}
