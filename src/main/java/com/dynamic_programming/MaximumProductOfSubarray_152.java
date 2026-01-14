package com.dynamic_programming;

public class MaximumProductOfSubarray_152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n], minDp = new int[n];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i],
                                Math.max(minDp[i - 1] * nums[i], nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i],
                                Math.min(maxDp[i - 1] * nums[i], nums[i]));

            res = Math.max(maxDp[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumProductOfSubarray_152 m = new MaximumProductOfSubarray_152();
        m.maxProduct(new int[]{2, 3, -2, -4, 4});
    }
}
