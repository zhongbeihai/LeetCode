package com.two_pointers;

public class UniquePathsII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n;j++){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePathsII_63 u = new UniquePathsII_63();
        // u.uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0},{0,0,0}});
        u.uniquePathsWithObstacles(new int[][]{{1,0}});
    }
}
