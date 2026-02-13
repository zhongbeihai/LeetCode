package com.dynamic_programming;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
