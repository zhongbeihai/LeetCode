package com.dynamic_programming;

public class CountWayToBuildGoodStrings_2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int mod = 1000000007;
        for(int i = 1; i <= high; i++){
            if(i - zero >= 0) dp[i] = (dp[i] + dp[i - zero]) % mod;
            if(i - one >= 0) dp[i] = (dp[i] + dp[i - one]) % mod;

        }

        int res = 0;
        for(int i = low; i <= high; i++){
            res = (res + dp[i]) % mod;
        }

        return res;
    }

    public static void main(String[] args) {
        CountWayToBuildGoodStrings_2466 c = new CountWayToBuildGoodStrings_2466();
        c.countGoodStrings(3,3,1,1);
    }
}
