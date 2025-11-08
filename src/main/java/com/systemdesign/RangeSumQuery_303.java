package com.systemdesign;

import java.util.Arrays;
import java.util.HashMap;

public class RangeSumQuery_303 {
    int[] prefixSum;
    public RangeSumQuery_303(int[] nums){
        int n = nums.length;
        prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right] - prefixSum[left - 1];
    }
}
