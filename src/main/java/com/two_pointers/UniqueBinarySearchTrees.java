package com.two_pointers;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // dp[i] is the unique BST when there are n nodes
        // F(1,n) -> 1 is the root node of a n-nodes BST
        //dp[i] = F(1,n) + F(2,n) ... + F(n,n)
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}
