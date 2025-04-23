package com.dynamic_programming;


public class BestTimeToBuyAndSellStockWithTransactionFee_714 {


    public int maxProfitEnhanced(int[] prices, int fee) {
        int hold = -prices[0];
        int sell = 0;

        for (int price : prices) {
            hold = Math.max(hold, sell - price);
            sell = Math.max(sell, hold + price - fee);
        }
        return sell;
    }
}
