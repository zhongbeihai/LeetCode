package com.dynamic_programming;

public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        // greedy algorithm
        int cumulativeProfit = 0;
        int hold = prices[0];
        for (int i = 0; i < prices.length; i++){
            if (prices[i] > hold) {
                cumulativeProfit += prices[i] - hold;
            }
            hold = prices[i];
        }

        return cumulativeProfit;
    }

    public int dp(int[] prices){
        int hold = -prices[0], cash = 0;

        for (int i = 0; i < prices.length; i++) {
            hold = Math.max(hold, cash - prices[i]); // hold the stock or buy it today
            cash = Math.max(cash, prices[i] + hold);
        }

        return cash;
    }
}
