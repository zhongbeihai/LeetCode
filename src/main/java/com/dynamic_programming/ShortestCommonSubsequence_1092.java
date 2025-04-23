package com.dynamic_programming;

public class ShortestCommonSubsequence_1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        String[][] dp = new String[n + 1][m + 1];
        for (int i = 0; i <= n; i++){
            dp[i][0] = "";
        }

        for (int i = 0; i <= m; i++){
            dp[0][i] = "";
        }
        for (int i = 1; i <= n; i++){
            for (int j =1; j <= m; j++){
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i- 1][j - 1] + str1.charAt(i - 1);
                }else {
                    if (dp[i - 1][j] .length() >= dp[i][j - 1].length()) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: dp[n][m].toCharArray()){
            while (p1 < n && str1.charAt(p1) != c) sb.append(str1.charAt(p1++));
            while (p2 < m && str2.charAt(p2) != c) sb.append(str2.charAt(p2++));
            sb.append(c);
            p1++; p2++;
        }
        while (p1 < n) sb.append(str1.charAt(p1++));
        while (p2 < m) sb.append(str2.charAt(p2++));
        return sb.toString();

    }

    public static void main(String[] args) {
        ShortestCommonSubsequence_1092 s = new ShortestCommonSubsequence_1092();
        s.shortestCommonSupersequence("abac","cab");
    }
}
