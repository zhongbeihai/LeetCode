package com.dynamic_programming;

public class MaximumProductOfSubarray_152 {
    public int maxProduct(int[] nums) {
        int dpMax = nums[0]; // maintain the maximum number end at i
        int dpMin = nums[0];

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < 0){
                int tem = dpMax;
                dpMax = dpMin;
                dpMin = tem;
            }
            dpMax = Math.max(nums[i], dpMax * nums[i]);
            dpMin = Math.min(nums[i], dpMin * nums[i]);
            ans = Math.max(ans, dpMax);
        }

        return ans;
    }
}
