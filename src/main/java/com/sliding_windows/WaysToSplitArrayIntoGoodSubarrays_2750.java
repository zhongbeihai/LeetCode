package com.sliding_windows;

public class WaysToSplitArrayIntoGoodSubarrays_2750 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length, left = 0, modulo = 1000000007;
        long res = 1;

        while(left < n && nums[left] != 1) left++;
        if (left == n) return 0;
        for (int right = left + 1; right < n; right++){
            if (nums[right] == 1){
                if (res == 0) res = 1;
                res *= (right -  left );
                res %= modulo;
                left = right;
            }
        }

        return (int)res;
    }
}
