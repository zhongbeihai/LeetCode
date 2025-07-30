package com.sliding_windows;

public class LongestSubarrayWithMaximumBitwiseAnd_2419 {
    public int longestSubarray(int[] nums) {
        int maxx = Integer.MIN_VALUE;
        for (int num: nums){
            maxx = Math.max(maxx, num);
        }

        int left = 0, maxLen = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] == maxx){
                maxLen = Math.max(maxLen, right - left + 1);
            }else {
                left = right;
            }
        }

        return maxLen;
    }
}
