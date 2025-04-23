package com.dynamic_programming;

import java.util.Arrays;

public class PartitionEqualSumSubset_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }

        if (sum % 2 != 0) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums){
            for (int i = sum; i >= num; i--){
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        PartitionEqualSumSubset_416 p = new PartitionEqualSumSubset_416();
        p.canPartition(new int[]{1,5,11,5});
    }
}
