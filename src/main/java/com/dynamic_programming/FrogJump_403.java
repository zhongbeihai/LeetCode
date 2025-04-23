package com.dynamic_programming;

import java.util.Arrays;

public class FrogJump_403 {
    public boolean canCross(int[] stones) {
        boolean[] dp = new boolean[stones.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        dp[1] = true;
        int[] kMin = new int[stones.length], kMax = new int[stones.length];
        kMin[1] = stones[1] - stones[0] - 1;
        kMax[1] = stones[1] - stones[0] + 1;
        for(int i = 2; i < stones.length; i++){
            if(stones[i] - stones[i - 1] >= kMin[i - 1] && stones[i] - stones[i - 1]  <= kMax[i - 1]){
                dp[i] = true && dp[i - 1];
                kMin[i] = Math.min(kMin[i - 1] , stones[i] - stones[i - 1] - 1);
                kMax[i] = Math.min(stones[i] - stones[i - 1] + 1, kMax[i - 1] + 1);
            }
        }

        return dp[stones.length - 1];
    }

    public static void main(String[] args) {
        FrogJump_403 f= new FrogJump_403();
        f.canCross(new int[]{0,1,3,5,6,8,12,17});
    }
}
