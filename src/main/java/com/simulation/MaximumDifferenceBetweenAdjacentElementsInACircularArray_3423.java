package com.simulation;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray_3423 {
    public int maxAdjacentDistance(int[] nums) {
        int res = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            res = Math.max(res, Math.abs(nums[i] - nums[(i + 1) % n]));
        }

        return res;
    }
}
