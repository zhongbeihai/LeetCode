package com.simulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheMaximumLengthOfValidSequenceII_3202 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 1;
        int[][] dp = new int[n][k];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], 1);

            for (int j = 0; j < i; j++){
                int curMod = (nums[j] + nums[i]) % k;
                dp[i][curMod] = Math.max(dp[i][curMod], dp[j][curMod] + 1);
                maxLen = Math.max(maxLen, dp[i][curMod]);
            }
        }

        return maxLen;
    }

}
