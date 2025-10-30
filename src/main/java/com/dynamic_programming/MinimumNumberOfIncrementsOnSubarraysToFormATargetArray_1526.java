package com.dynamic_programming;

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526 {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int[] dp = new int[n];
        dp[0] = target[0];

        for (int i = 1; i < n; i++){
            if (target[i] > target[i - 1])
                dp[i] = dp[i - 1] + target[i] - target[i - 1];
            else dp[i] = dp[i - 1];
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526 m = new MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526();
        m.minNumberOperations(new int[]{3,1,1,2});
    }
}
