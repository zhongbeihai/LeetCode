package com.dynamic_programming;

public class LongestPalindromeSubstring_5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        String res = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--){
                if (s.charAt(j) == s.charAt(i) && (i - j == 1 || dp[j + 1][i - 1])) {
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
        l.longestPalindrome("bbccba");
    }
}
