package com.dynamic_programming;

public class MinimumIncrementOperationsToMakeArrayBeautiful_2919 {
    public long minIncrementOperations(int[] nums, int k) {
        long[] dp = new long[nums.length];
        if(nums[0] < k) dp[0] = k - nums[0];
        if(nums[1] < k) dp[1] = k - nums[1];
        if(nums[2] < k) dp[2] = k - nums[2];
        for(int i = 3; i < nums.length; i++){
            int operations = 0;
            if(nums[i] < k) operations = k - nums[i];
            dp[i] = operations + Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3]));
        }

        return Math.min(dp[nums.length - 3], Math.min(dp[nums.length - 2], dp[nums.length - 1]));
    }
}
