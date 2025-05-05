package com.dynamic_programming;

public class DominoAndTrominoTiling_790 {
    public int numTilings(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        // dp[n] = (dp[n - 2] * 2) + dp[n - 1] + dp[n - 3] * 2)
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] * 2 + dp[i - 3] % 1_000_000_007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DominoAndTrominoTiling_790 d = new DominoAndTrominoTiling_790();
        d.numTilings(5);
    }
}
