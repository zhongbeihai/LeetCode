package com.dynamic_programming;

public class PalindromeSubstrings_647 {
    public int countSubstrings(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length, res = 0;
        boolean[][] dp = new boolean[n][n]; // dp[i][j] -> is palindrome substring(i, j + 1)
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = n - 2; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                if (ss[i] == ss[j] && (j - i == 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PalindromeSubstrings_647 p = new PalindromeSubstrings_647();
        p.countSubstrings("aaa");
    }
}
