package com.dynamic_programming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII_123 {
    public int maxProfit(int[] prices) {
        int[] hold = new int[3], cash = new int[3];
        Arrays.fill(hold, -prices[0]);

        for (int i = 0; i < prices.length; i++) {
            for (int j = 2; j >= 1; --j) {
                cash[j] = Math.max(cash[j], hold[j] + prices[i]);
                hold[j] = Math.max(hold[j], cash[j - 1] - prices[i]);
            }
        }

        return cash[2];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII_123 b = new BestTimeToBuyAndSellStockIII_123();
        b.maxProfit(new int[]{3,5,0,3,1,4});
    }
}
