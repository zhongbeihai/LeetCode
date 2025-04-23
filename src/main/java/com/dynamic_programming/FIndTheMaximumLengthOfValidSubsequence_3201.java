package com.dynamic_programming;

import java.util.Arrays;

public class FIndTheMaximumLengthOfValidSubsequence_3201 {
    public int maximumLength(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][2];

        for (int[] d: dp){
            Arrays.fill(d, 1);
        }

        int res = 0;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if ((nums[i] + nums[j]) % 2 == 0){
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                } else if ((nums[i] + nums[j]) % 2 == 1) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }

            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

        return res;
    }

    public static void main(String[] args) {
        FIndTheMaximumLengthOfValidSubsequence_3201 f = new FIndTheMaximumLengthOfValidSubsequence_3201();
        f.maximumLength(new int[]{1,2,1,1,2,1,2});
    }
}
