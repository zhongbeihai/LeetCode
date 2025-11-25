package com.dynamic_programming;

public class GreatestSumDibisibleByThree_1262 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++){
            int x = nums[i - 1];
            for (int j = 0; j < 3; j++) {
                // don't choose x
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                // choose x
                int nr = (dp[i - 1][j] + x) % 3;
                dp[i][nr] = Math.max(dp[i][nr], dp[i - 1][j] + x);
            }
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        GreatestSumDibisibleByThree_1262 g= new GreatestSumDibisibleByThree_1262();
        g.maxSumDivThree(new int[]{3,6,5,1,8});
    }
}
