package com.dynamic_programming;

public class BurstBalloons_312 {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        dp[0][0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                int leftInd = i, rightInd = j;
                for (int k = leftInd; k <= rightInd; k++) {
                    int left = k == leftInd ? 0 : dp[leftInd][k - 1];
                    int right = k == rightInd ? 0 : dp[k+1][rightInd];
                    int current = nums[k] * (leftInd > 0 ? nums[leftInd - 1] : 1)
                            * (rightInd + 1 < nums.length ? nums[rightInd + 1] : 1);
                    dp[leftInd][rightInd] = Math.max(dp[leftInd][rightInd], left + right + current);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
