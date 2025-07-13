package com.dynamic_programming;

import java.util.Arrays;

public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0 || Math.abs(sum) < Math.abs(target)) return 0;

        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int num: nums){
            for (int j = bagSize; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }

        return dp[bagSize];
    }
}
