package com.dynamic_programming;

import java.util.Arrays;

public class MinimumFallingPathSumII_1289 {
    public int minFallingPathSum(int[][] grid) {
        int[] dp = grid[0].clone();


        for (int i = 1; i < grid.length; i++){
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int indexMin1 = -1;

            for (int j = 0; j < grid.length; j++) {
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    indexMin1 = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }

            int[] newDp = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                if (j == indexMin1) {
                    newDp[j] = grid[i][j] + min2; // Use the second smallest value
                } else {
                    newDp[j] = grid[i][j] + min1; // Use the smallest value
                }
            }
            dp =newDp;
        }
        int result = Integer.MAX_VALUE;
        for (int value : dp) {
            result = Math.min(result, value);
        }
        return result;
    }



    public static void main(String[] args) {
        MinimumFallingPathSumII_1289 m = new MinimumFallingPathSumII_1289();
        m.minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
