package com.simulation;

public class MaximumAscendingSubarraySum_1800 {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] <= nums[i - 1] ){
                sum = 0;
            }
            sum += nums[i];
            res = Math.max(res, sum);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumAscendingSubarraySum_1800 m = new MaximumAscendingSubarraySum_1800();
        m.maxAscendingSum(new int[]{3,6,10,1,8,9,9,8,9});
    }
}
