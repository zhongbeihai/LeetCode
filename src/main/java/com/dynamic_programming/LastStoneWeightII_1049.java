package com.dynamic_programming;

import java.util.Arrays;

public class LastStoneWeightII_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        int maxI = 0;

        Arrays.sort(stones);
        for(int stone: stones){
            for(int i = target; i >= stone; i--){
                dp[i] = dp[i] ||dp[i - stone];
                if(dp[i]) {
                    if (i == target) return sum - target - target;
                    maxI = Math.max(maxI, i);
                }

            }
        }

        return sum - maxI - maxI;
    }

    public static void main(String[] args) {
        LastStoneWeightII_1049 l = new LastStoneWeightII_1049();
        l.lastStoneWeightII(new int[]{34,30,6,25,13,32});
    }
}
