package com.search;

import java.util.Arrays;

public class MinimumSizeSumArray_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;

        int sum = 0, minLen = Integer.MAX_VALUE;
        for (right = 0; right < n; right++){
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinimumSizeSumArray_209 m = new MinimumSizeSumArray_209();
        m.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
