package com.simulation;

import com.search.MaximumNumberOfFish_2658;

public class LongestStrictlyIncreaseOrDecreaseSubarray_3105 {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        int maxIn = 1, maxDe = 1, p = 0, n = nums.length, maxLength = 1;
        while (p + 1 < n){
            if (nums[p] == nums[p + 1]) {
                maxIn = 1;
                maxDe = 1;
            }
            if (nums[p] < nums[p + 1]){
                maxIn++;
                maxDe = 1;
                maxLength = Math.max(maxIn, maxLength);
            }
            if (nums[p] > nums[p + 1]){
                maxDe++;
                maxIn = 1;
                maxLength = Math.max(maxDe, maxLength);
            }
            p++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestStrictlyIncreaseOrDecreaseSubarray_3105 l = new LongestStrictlyIncreaseOrDecreaseSubarray_3105();
        l.longestMonotonicSubarray(new int[]{1,10,10});
    }
}
