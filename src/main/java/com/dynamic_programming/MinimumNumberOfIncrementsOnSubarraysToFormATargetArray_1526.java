package com.dynamic_programming;

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526 {
    public int minNumberOperations(int[] target) {
        int[] dp = new int[target.length];

        dp[target.length - 1] = target[target.length - 1];
        for(int i = target.length - 2; i >= 0; i--){
            if(target[i] <= target[i + 1]) dp[i] = dp[i + 1];
            else dp[i] = dp[i + 1] + target[i] - target[i + 1];
        }

        return dp[0];
    }

    public static void main(String[] args) {
        MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526 m = new MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526();
        m.minNumberOperations(new int[]{3,1,1,2});
    }
}
