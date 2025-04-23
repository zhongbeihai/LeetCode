package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonCN1 {
    private static long res = 0;
    public static long maximizeTotalMemoryPoints(List<Integer> memory) {
        int[]arr = memory.stream().mapToInt(Integer::intValue).toArray();
        // Write your code here
        backTrack(memory, new int[memory.size()], 0);
        return res;
    }

    public static void backTrack(List<Integer> memory, int[] tem, int pos){
        if (pos == tem.length){
            res = Math.max(res, Arrays.stream(tem).sum());
            return;
        }

        for (int i = 0; i < memory.size(); i++){
            if (memory.get(i) == 0) continue;
            int p = memory.get(i);
            if (pos == 0) tem[pos] = memory.get(i);
            else tem[pos] = tem[pos - 1] + memory.get(i);
            memory.set(i, 0);

            backTrack(memory, tem, pos + 1);

            tem[pos] = 0;
            memory.set(i, p);
        }
    }

    public static int minimumPowerAdjustment(int[] serverPowers) {
        int n = serverPowers.length;

        // Create a copy of the original array to work with
        int[] sortedPowers = Arrays.copyOf(serverPowers, n);
        Arrays.sort(sortedPowers);

        // Initialize dp array to track minimum cost
        // dp[i][j] represents the minimum cost to make the first i+1 elements
        // non-decreasing with the i-th element having a value of at least sortedPowers[j]
        int[][] dp = new int[n][n];

        // Fill dp array with a large value initially
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        // Base case: cost for the first element
        for (int j = 0; j < n; j++) {
            dp[0][j] = Math.max(0, sortedPowers[j] - serverPowers[0]);
        }

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Try all possible values for the previous element
                for (int k = 0; k <= j; k++) {
                    int currentCost = dp[i-1][k] + Math.max(0, sortedPowers[j] - serverPowers[i]);
                    dp[i][j] = Math.min(dp[i][j], currentCost);
                }
            }
        }

        // Find the minimum total cost from the last row
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minCost = Math.min(minCost, dp[n-1][j]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        AmazonCN1.minimumPowerAdjustment(new int[]{3,3,2,1});
    }
}
