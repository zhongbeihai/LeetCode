package com.dynamic_programming;

import java.util.Arrays;
import java.util.Stack;

public class MinimumTimeToMakeRopeColorful_1578 {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int[] dp = new int[n];

        for (int i = 1; i < n; i++){
            if (colors.charAt(i) != colors.charAt(i - 1)) dp[i] = dp[i - 1];
            else {
                dp[i] = dp[i - 1] + Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i - 1], neededTime[i]);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful_1578 m = new MinimumTimeToMakeRopeColorful_1578();
        m.minCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1});
    }
}
