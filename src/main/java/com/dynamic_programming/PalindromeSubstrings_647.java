package com.dynamic_programming;

public class PalindromeSubstrings_647 {
    public int countSubstrings(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int cnt = n;
        for (int i = n - 1; i >= 0 ;i--){
            for (int j = i + 1; j < n; j++) {
                if (ss[i] == ss[j] && (dp[i+1][j - 1] || j - i < 2)) {
                    dp[i][j] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        PalindromeSubstrings_647 p = new PalindromeSubstrings_647();
        p.countSubstrings("aaa");
    }
}
