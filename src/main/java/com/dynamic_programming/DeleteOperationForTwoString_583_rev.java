package com.dynamic_programming;

public class DeleteOperationForTwoString_583_rev {
    public int minDistance(String word1, String word2) {
        int m = word1.length() , n = word2.length();
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;  // Initialize memoization table with -1
            }
        }

        return dp(word1, m - 1, word2, n - 1, memo);
    }

    public int dp(String word1, int i, String word2, int j, int[][] memo){
        // word1 已经穷尽，word2还没有遍历完，则word2剩下的都删除，需要j+1步
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if(memo[i][j] != -1) return memo[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            // do nothing
            memo[i][j] = dp(word1, i-1, word2, j-1, memo);
        }else {
            memo[i][j] = Math.min(
                    dp(word1, i, word2, j - 1, memo) + 1,
                    dp(word1, i - 1, word2, j, memo) + 1
            );
        }

        return memo[i][j];
    }
}
