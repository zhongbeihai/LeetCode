package com.dynamic_programming;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0, start = 0, end = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for(int j = 0; j < i; j++){
                if(s.charAt(i) == s.charAt(j) && (dp[j+1][i-1] || i - j == 1)){
                    dp[j][i] = true;
                    if(i - j + 1 > maxLen){
                        maxLen = i - j + 1;
                        start = j;
                        end = i + 1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 l = new LongestPalindromicSubstring_5();
        l.longestPalindrome("aaaa");
    }
}
