package com.greedy;

import java.util.Arrays;

public class Candy_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++){
            if (ratings[i] > ratings[i - 1] && dp[i] <= dp[i - 1]) dp[i] = dp[i - 1] + 1;
        }

        for (int i = n - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) dp[i] = dp[i + 1] + 1;
        }

        int res = Arrays.stream(dp).sum();
        return res;
    }

    public static void main(String[] args) {
        Candy_135 c = new Candy_135();
        c.candy(new int[]{1,2,87,87,87,2,1});
    }
}
