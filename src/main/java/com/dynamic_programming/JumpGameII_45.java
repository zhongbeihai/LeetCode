package com.dynamic_programming;

import java.util.Arrays;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] -> minimum step jump to i
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i]; j++) {
                if (i + j + 1 < n) dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        JumpGameII_45 jk = new JumpGameII_45();
        jk.jump(new int[]{2,3,1,1,4});
    }
}
