package com.dynamic_programming;

import java.util.LinkedList;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int price: prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 b = new BestTimeToBuyAndSellStock_121();
        b.maxProfit(new int[]{1,2});
    }
}
