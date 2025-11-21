package com.prefixsum;

public class RunningSumOf1DArray_1480 {
    public int[] runningSum(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return prefixSum;
    }
}
