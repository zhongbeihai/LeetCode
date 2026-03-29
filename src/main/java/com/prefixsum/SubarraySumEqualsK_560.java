package com.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long[] prefixSum = new long[nums.length];

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = i > 0 ? prefixSum[i-1] + nums[i]: nums[i];
            if (map.containsKey(prefixSum[i] - k)){
                cnt += map.get(prefixSum[i] - k);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 s = new SubarraySumEqualsK_560();
         s.subarraySum(new int[]{1,2,3}, 3);
        // s.subarraySum(new int[]{-1, -1 , 1}, 0);
    }
}
