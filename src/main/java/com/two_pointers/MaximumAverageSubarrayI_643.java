package com.two_pointers;

public class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, left = 0;

        double sum = 0, maxAverage = Integer.MIN_VALUE;
        for(int right = 0; right < n; right++){
            sum += nums[right];
            if (right - left == k - 1) {
                maxAverage = Math.max(maxAverage, sum / k);
                sum -= nums[left];
                left++;
            }
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI_643 m = new MaximumAverageSubarrayI_643();
        m.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
    }
}
