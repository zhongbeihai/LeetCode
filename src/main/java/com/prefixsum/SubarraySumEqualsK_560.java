package com.prefixsum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        long curSum = 0L;
        HashMap<Long, Integer> fre = new HashMap<>();
        fre.put(0L, 1);
        int res = 0;
        for (int num: nums){
            curSum += num;
            fre.put(curSum, fre.getOrDefault(curSum, 0) + 1);
            long need = curSum - k;
            if (fre.containsKey(need)) res += fre.get(need);
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 s = new SubarraySumEqualsK_560();
        s.subarraySum(new int[]{1,2,3}, 3);
    }
}
