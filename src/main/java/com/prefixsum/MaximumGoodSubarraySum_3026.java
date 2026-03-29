package com.prefixsum;

import java.util.HashMap;

public class MaximumGoodSubarraySum_3026 {
    public long maximumSubarraySum(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxSum = Long.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            if (map.containsKey(nums[i - 1] - k)){
                int j1 = map.get(nums[i - 1] - k);
                maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[j1 - 1]);
            }
            if(map.containsKey(nums[i - 1] + k)){
                int j2 = map.get(nums[i - 1] + k);
                maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[j2 - 1]);
            }
            if (!map.containsKey(nums[i - 1])){
                map.put(nums[i - 1], i);
            }else {
                if (prefixSum[map.get(nums[i - 1])] > prefixSum[i]) map.put(nums[i - 1], i);
            }
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }

    public static void main(String[] args) {
        MaximumGoodSubarraySum_3026 m = new MaximumGoodSubarraySum_3026();
        m.maximumSubarraySum(new int[]{-1,-2,-3,-4}, 2);
    }
}
