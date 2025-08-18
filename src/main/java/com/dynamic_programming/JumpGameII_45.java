package com.dynamic_programming;

import java.util.Arrays;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        // dp[i] is minimum number of jumps to i
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (j + nums[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        JumpGameII_45 jk = new JumpGameII_45();
        jk.jump(new int[]{2,3,1,1,4});
    }
}
