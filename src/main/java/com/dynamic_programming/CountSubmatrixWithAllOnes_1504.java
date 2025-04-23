package com.dynamic_programming;

public class CountSubmatrixWithAllOnes_1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            int count = 0;
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 1) count++;
                else  count = 0;
                dp[i][j] = count;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int res = Integer.MAX_VALUE;
                for (int k = i; k < m; k++){
                    if (mat[k][j] == 0) continue;
                    res = Math.min(dp[k][j], res);
                    ans += res;
                }
            }
        }

        return ans;
    }
}
