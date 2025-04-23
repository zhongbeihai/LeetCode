package com.dynamic_programming;

public class DistinctSubseqence_115 {
    public int numDistinct(String s, String t) {
        int sl = s.length(), tl = t.length();

        int[][] dp = new int[tl + 1][sl + 1];

        for(int i=0; i<=sl; ++i){
            dp[0][i] = 1;
        }


        for (int tc = 1; tc <= tl; tc++){
            for (int sc = 1; sc <= sl; sc++){
                if (t.charAt(tc - 1) == s.charAt(sc - 1)){
                    dp[tc][sc] = dp[tc][sc - 1] + dp[tc -1][sc - 1];
                }else {
                    dp[tc][sc] = dp[tc][sc - 1];
                }
            }
        }

        return dp[tl - 1][sl - 1];
    }

    public static void main(String[] args) {
        DistinctSubseqence_115 d = new DistinctSubseqence_115();
        d.numDistinct("babgbag", "bag");
    }
}
