package com.dynamic_programming;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            maxx = Math.max(maxx, dp[i]);
        }

        return maxx;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence_674 l = new LongestContinuousIncreasingSubsequence_674();
        l.findLengthOfLCIS(new int[]{1,3,5,4,7});
    }
}
