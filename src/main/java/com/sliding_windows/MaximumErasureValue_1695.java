package com.sliding_windows;

import java.util.HashSet;

public class MaximumErasureValue_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, curSum = 0, res = 0, n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        for (int right = 0; right < n; right++){
            curSum += nums[right];
            while (left <= right && set.contains(nums[right])){
                curSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);

            res = Math.max(curSum, res);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumErasureValue_1695 m = new MaximumErasureValue_1695();
        m.maximumUniqueSubarray(new int[]{4,2,4,5,6});
    }
}
