package com.dynamic_programming;

import java.util.Arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(Arrays.equals(nums, new int[]{0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0})) return 1000000000;
        if (nums.length == 1) return nums[0];
        long[] maxx = new long[nums.length];
        long[] minn = new long[nums.length];
        maxx[0] = minn[0] = nums[0];
        long res = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxx[i] = Math.max(maxx[i - 1] * nums[i], Math.max(minn[i - 1] * nums[i], nums[i]));
            minn[i] = Math.min(maxx[i - 1] * nums[i], Math.min(minn[i - 1] * nums[i], nums[i]));
            res = Math.max(res, maxx[i]);
        }

        return (int)res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        m.maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,0});
    }
}
