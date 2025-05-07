package com.dynamic_programming;

public class PaintFence_276 {
    public int numWays(int n, int k) {
        if (n <= 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * dp[0];
        for (int i = 2; i < n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        PaintFence_276 p = new PaintFence_276();
        p.numWays(2, 3);
    }
}
