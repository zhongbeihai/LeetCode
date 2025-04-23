package com.prefixsum;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualK_325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int curSum = 0;
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();

        int maxLen = 0;
        for (int i =0; i < n; i++){
            curSum += nums[i];
            if (curSum == k) maxLen = i + 1;
            if (sumToIndex.containsKey(curSum - k)) maxLen = Math.max(maxLen, i - sumToIndex.get(curSum - k) + 1);
            sumToIndex.putIfAbsent(curSum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualK_325 m = new MaximumSizeSubarraySumEqualK_325();
        m.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3);
    }
}
