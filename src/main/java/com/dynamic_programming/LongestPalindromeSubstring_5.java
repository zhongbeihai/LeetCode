package com.dynamic_programming;

public class LongestPalindromeSubstring_5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        char[] ss = s.toCharArray();
        int n = ss.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;

        String res = String.valueOf(ss[0]);
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (ss[j] == ss[i] && (i - j == 1 || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                    if (i - j + 1 > res.length()) res = s.substring(j, i + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring_5 l = new LongestPalindromeSubstring_5();
        // l.longestPalindrome("aacabdkacaa");
        l.longestPalindrome("aaaa");
    }
}
