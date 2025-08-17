package com.dynamic_programming;

public class LongestPalindromeSubstring_5 {
    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0, end = 0;
        int maxLen = 0;
        for (int i = n - 1; i >=0 ; i--){
            for (int j = i + 1; j < n; j++){
                if (ss[i] == ss[j] && (dp[i+1][j-1] || j - i < 2)){
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        start = i; end = j;
                        maxLen = j - i + 1;
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
