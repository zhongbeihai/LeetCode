package com.search;

import java.util.Arrays;

public class MinimumSizeSumArray_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0, ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1); // 先更新
                sum -= nums[left++];                 // 再收缩左端
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        MinimumSizeSumArray_209 m = new MinimumSizeSumArray_209();
        m.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
