package com.dynamic_programming;

import java.util.LinkedList;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 b = new BestTimeToBuyAndSellStock_121();
        b.maxProfit(new int[]{1,2});
    }
}
