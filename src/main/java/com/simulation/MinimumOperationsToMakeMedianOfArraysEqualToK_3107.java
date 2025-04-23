package com.simulation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumOperationsToMakeMedianOfArraysEqualToK_3107 {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int l = mid;
        long cnt = 0;
        while (l >= 0 &&nums[l] > k){
            cnt += nums[l] - k;
            nums[l] = k;
            l--;
        }
        int r = mid;
        while (r < nums.length && nums[r] < k){
            cnt += k - nums[r];
            nums[r] = k;
            r++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeMedianOfArraysEqualToK_3107 m = new MinimumOperationsToMakeMedianOfArraysEqualToK_3107();
        m.minOperationsToMakeMedianK(new int[]{1}, 1000000000);
    }
}
