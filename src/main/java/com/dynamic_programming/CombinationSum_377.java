package com.dynamic_programming;

import com.backtrack.ConcatenatedWords_472;

public class CombinationSum_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int num: nums){
                if(i - num >= 0) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum_377 c = new CombinationSum_377();
        c.combinationSum4(new int[]{1,2,3}, 4);
    }
}
