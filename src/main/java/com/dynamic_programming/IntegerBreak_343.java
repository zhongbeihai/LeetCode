package com.dynamic_programming;

public class IntegerBreak_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        if (n <= 1) return 0;
        return maxProduct(dp , n);
    }

    public int maxProduct(int[] dp, int n){
        if (n == 2) return 1;

        if (dp[n] != 0) return dp[n];

        int max = 0;
        for (int i = 1; i < n; i++){
            max = Math.max(max, Math.max(i * (n - i), i * maxProduct(dp, n - i)));
        }

        dp[n] = max;
        return max;
    }

    public static void main(String[] args) {
        IntegerBreak_343 i = new IntegerBreak_343();
        i.integerBreak(10);
    }
}
