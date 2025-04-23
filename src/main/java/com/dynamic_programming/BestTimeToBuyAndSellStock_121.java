package com.dynamic_programming;

import java.util.LinkedList;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        // dp[i] is the minimum cost between time 0 - ith
        int n = prices.length;
        int dp = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++){
            dp = Math.min(dp, prices[i]);
            if (prices[i] - dp > res) res = prices[i] - dp;
        }

        return res;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 b = new BestTimeToBuyAndSellStock_121();
        b.maxProfit(new int[]{1,2});
    }
}
