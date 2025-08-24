package com.dynamic_programming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
class CoinChange_322 {
    public int coinChange(int[] coins, int amount){
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin: coins){
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        CoinChange_322 c = new CoinChange_322();
        //c.coinChange(new int[]{1, 2147483447}, 2);
        c.coinChange(new int[]{1,2,5}, 11);
    }
}
