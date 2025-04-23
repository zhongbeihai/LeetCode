package com.prefixsum;

public class NumverOfWayToSplitArray_2270 {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];

        for(int i = 1; i <= nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int res = 0;
        long max = prefixSum[prefixSum.length - 1];
        for (int i = 1; i < prefixSum.length - 1; i++){
            if(prefixSum[i] >= (max - prefixSum[i])) res++;
        }

        return res;
    }
}
