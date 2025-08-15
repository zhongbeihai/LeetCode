package com.dynamic_programming;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int dpMax = nums[0]; // maintain the maximum number ending at i
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++){
            dpMax = Math.max(nums[i], dpMax + nums[i]);

            ans = Math.max(ans, dpMax);
        }

        return ans;
    }
}
