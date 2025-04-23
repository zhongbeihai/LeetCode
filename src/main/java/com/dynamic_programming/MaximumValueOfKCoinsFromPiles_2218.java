package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumValueOfKCoinsFromPiles_2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        //dp[i] -> max value when pick i coins
        int[] dp = new int[k + 1];

        // traverse all the piles
        for(List<Integer> pile: piles){
            int n = pile.size();
            int[] prefixSum = new int[n + 1];

            for(int p = 1; p <= n; p++){
                prefixSum[p] += prefixSum[p - 1] + pile.get(p);
            }

            for(int j = k; j >=0; j--){
                for(int x = 1; x <= j && x <= n; x++){
                    dp[j] = Math.max(dp[j], dp[j - x] + prefixSum[x]);
                }
            }
        }

        return dp[k];
    }

    public static void main(String[] args) {
        MaximumValueOfKCoinsFromPiles_2218 m = new MaximumValueOfKCoinsFromPiles_2218();
        int[][] piles = {
                {100},
                {100},
                {100},
                {100},
                {100},
                {100},
                {1, 1, 1, 1, 1, 1, 700}
        };

        List<List<Integer>> list = new ArrayList<>();
        for (int[] pile : piles) {
            list.add(Arrays.asList(Arrays.stream(pile).boxed().toArray(Integer[]::new)));
        }

        m.maxValueOfCoins(list, 7);
    }
}
