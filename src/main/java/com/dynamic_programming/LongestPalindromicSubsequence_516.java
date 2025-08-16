package com.dynamic_programming;

public class LongestPalindromicSubsequence_516 {
    public int longestPalindromeSubseq(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n]; // dp[i][j] -> the longest palindrome from i to j
        for (int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                if (ss[i] == ss[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i+ 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }
}
