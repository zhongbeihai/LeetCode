package com.sliding_windows;

public class MaximumSumCircularSubarray_918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num: nums) sum += num;

        int maxS = Integer.MIN_VALUE, minS = Integer.MAX_VALUE;
        int  minSum = 0, maxSum = 0;
        for (int right = 0; right < n; right++){
            minSum = Math.min(nums[right], minSum + nums[right]);
            minS = Math.min(minS, minSum);

            maxSum = Math.max(nums[right], maxSum + nums[right]);
            maxS = Math.max(maxS, maxSum);
        }


        if (maxS < 0) return maxS;
        return Math.max(maxS, sum - minS);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray_918 m = new MaximumSumCircularSubarray_918();
        m.maxSubarraySumCircular(new int[]{1,-2,3,-2});
    }
}
