package com.dynamic_programming;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length]; // dp[i] -> the maximum number we can get from the subarray that ending with nums[i]
        dp[0] = nums[0];

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // transition function
            // dp[i] = (dp[i - 1] + nums[i], nums[i])
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
