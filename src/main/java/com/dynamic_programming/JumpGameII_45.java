package com.dynamic_programming;

import java.util.Arrays;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        // dp[i] is minimum number of jumps to i
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++){
            int n = nums[i - 1];
            for (int j = i; j < i + n ; j++){
                dp[j] = Math.min(dp[j], dp[i - 1] + 1);
                if(dp[nums.length - 1] != Integer.MAX_VALUE) return dp[nums.length - 1];
            }

        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        JumpGameII_45 jk = new JumpGameII_45();
        jk.jump(new int[]{2,1});
    }
}
