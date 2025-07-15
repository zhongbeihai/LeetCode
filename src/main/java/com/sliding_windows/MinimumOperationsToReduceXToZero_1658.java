package com.sliding_windows;

import java.util.Arrays;

public class MinimumOperationsToReduceXToZero_1658 {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) total += num;
        int target = total - x;

        int left= 0, n = nums.length, maxLength = -1;
        int curSum = 0;
        for (int right = 0; right < n; right++){
            curSum += nums[right];
            while (left <= right && curSum > target){
                curSum -= nums[left];
                left++;
            }
            if (curSum == target){
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        if (maxLength == -1) return maxLength;
        else return n - maxLength;
    }

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero_1658 m = new MinimumOperationsToReduceXToZero_1658();
        m.minOperations(new int[]{3,2,20,1,1,3}, 10);
    }
}
