package com.dynamic_programming;

public class MaximumAbsoluteSumOfAnySubarray_1749 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        // min sum ending with i
        dp[0][0] = nums[0];
        // max sum ending with i
        dp[0][1] = nums[0];

        int absMax = nums[0];
        for (int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i - 1][0] + nums[i], nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + nums[i], nums[i]);
            absMax = Math.max(absMax, Math.max(Math.abs(dp[i][0]), dp[i][1]));
        }

        return absMax;
    }

    public static void main(String[] args) {
        MaximumAbsoluteSumOfAnySubarray_1749 m = new MaximumAbsoluteSumOfAnySubarray_1749();
        m.maxAbsoluteSum(new int[]{1,-3,2,3,-4});
    }
}
