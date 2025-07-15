package com.two_pointers;

public class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0, end = 0;
        double sum = 0;
        double max =Integer.MIN_VALUE;
        while (end < k){
            sum += nums[end];
            end++;
        }
        max = Math.max(sum, max);
        while (end < nums.length){
            sum += nums[end];
            end++;
            sum -= nums[start];
            start++;
            max = Math.max(sum, max);
        }
        return max/k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI_643 m = new MaximumAverageSubarrayI_643();
        m.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
    }
}
