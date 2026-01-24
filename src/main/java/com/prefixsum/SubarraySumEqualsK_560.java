package com.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        int n  = nums.length;
        Map<Long, Integer> fre = new HashMap<>();
        long curSum = 0;

        int res = 0;
        fre.put(0L, 1);
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (fre.containsKey(curSum - k)) res += fre.get(curSum - k);
            fre.put(curSum, fre.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 s = new SubarraySumEqualsK_560();
         s.subarraySum(new int[]{1,2,3}, 3);
        // s.subarraySum(new int[]{-1, -1 , 1}, 0);
    }
}
