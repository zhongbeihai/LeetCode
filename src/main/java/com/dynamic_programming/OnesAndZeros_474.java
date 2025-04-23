package com.dynamic_programming;

import javafx.util.Pair;

public class OnesAndZeros_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(String str: strs){
            int[] cc = countZAndO(str);
            for(int i = m; i >= cc[0]; i--){
                for(int j = n; j >= cc[1]; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - cc[0]][j - cc[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] countZAndO(String s){
        int[] ans = new int[2];
        for(char c : s.toCharArray()) {
            if(c == '0') ans[0]++;
            else if(c == '1') ans[1]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        OnesAndZeros_474 o =new OnesAndZeros_474();
        o.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 4);
    }
}
