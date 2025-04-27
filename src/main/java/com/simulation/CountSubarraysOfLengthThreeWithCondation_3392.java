package com.simulation;

public class CountSubarraysOfLengthThreeWithCondation_3392 {
    public int countSubarrays(int[] nums) {
        int res = 0;
        if (nums.length < 3) return 0;
        for (int i = 2; i < nums.length; i++){
            int mid = nums[i -1];
            int lr = nums[i - 2] + nums[i];
            if (mid == lr * 2) res++;

        }

        return res;
    }
}
