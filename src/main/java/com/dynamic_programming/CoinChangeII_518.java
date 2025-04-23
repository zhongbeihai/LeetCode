package com.dynamic_programming;

public class CoinChangeII_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeII_518 c = new CoinChangeII_518();
        c.change(5, new int[]{1,2,5});
    }
}
