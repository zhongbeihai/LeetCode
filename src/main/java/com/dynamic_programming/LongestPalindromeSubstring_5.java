package com.dynamic_programming;

public class LongestPalindromeSubstring_5 {
    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0, end = 0, maxLength = 1;

        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (ss[j] == ss[i] && (dp[j + 1][i - 1] || i - j < 3)) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        start = j;
                        end = i;
                        maxLength = i - j + 1;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring_5 l = new LongestPalindromeSubstring_5();
        l.longestPalindrome("aacabdkacaa");
    }
}
