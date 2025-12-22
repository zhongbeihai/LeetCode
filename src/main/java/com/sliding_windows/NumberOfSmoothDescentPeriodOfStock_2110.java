package com.sliding_windows;

public class NumberOfSmoothDescentPeriodOfStock_2110 {
    public long getDescentPeriods(int[] prices) {
        long con = 1, res = 1;
        for (int right = 1; right < prices.length; right++) {
            if (prices[right - 1] - prices[right] == 1) {
                con++;
                res += con;
            }
            else {
                con = 1;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NumberOfSmoothDescentPeriodOfStock_2110 n = new NumberOfSmoothDescentPeriodOfStock_2110();
        n.getDescentPeriods(new int[]{3,2,1,3,2,1});
    }
}
