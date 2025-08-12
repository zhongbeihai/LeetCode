package com.dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WayToExpressIntegerAsSumOfPower_2787 {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        List<Integer> bags = new ArrayList<>();
        for (int a = 1; ; a++){
            int p = (int) Math.pow(a, x);
            if (p <= n) bags.add(p);
            else break;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int comp: bags){
            for (int i = n; i >= comp; i--){
                dp[i] += dp[i - comp];
                if (dp[i] > MOD) dp[i] -= MOD;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WayToExpressIntegerAsSumOfPower_2787 w = new WayToExpressIntegerAsSumOfPower_2787();
        w.numberOfWays(10, 2);
    }
}
