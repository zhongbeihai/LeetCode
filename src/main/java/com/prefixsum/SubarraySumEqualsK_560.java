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
        int ans = 0;
        long curSum = 0;
        // <sum, freq>
        HashMap<Long, Integer> map = new HashMap<>();
        // Sum is 0 occurs once
        map.put((long)0, 1);
        for(int i = 0; i < nums.length; i++){
            // sum[i - j] = preSum[i] - preSum[j - 1]
            // if exit K = preSum[i] - preSum[j-1]
            // exit preSum[j-1] = preSum[i] - k
            curSum += nums[i];
            if(map.containsKey(curSum - k)){
                ans += map.get(curSum - k);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 s = new SubarraySumEqualsK_560();
        s.subarraySum(new int[]{1,2,3}, 3);
    }
}
