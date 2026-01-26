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
        Map<Long, Integer> sumFre = new HashMap<>(); // <Sum, Last Occur Index>
        long curSum = 0L;

        int cnt = 0;
        sumFre.put(0L, 1);
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (sumFre.containsKey(curSum - k)) cnt += sumFre.get(curSum - k);

            sumFre.put(curSum, sumFre.getOrDefault(curSum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 s = new SubarraySumEqualsK_560();
         s.subarraySum(new int[]{1,2,3}, 3);
        // s.subarraySum(new int[]{-1, -1 , 1}, 0);
    }
}
