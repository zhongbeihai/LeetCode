package com.dynamic_programming;

import java.util.Arrays;

public class LongestIdealSubsequence_2370 {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];

        for(char c: s.toCharArray()){
            int indexC = c - 'a';
            int max_l = 0;
            for(int i = Math.max(indexC - k, 0); i <= indexC + k && i < 26; i++){
                max_l = Math.max(max_l, dp[i]);
            }
            dp[indexC] = max_l + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestIdealSubsequence_2370 l = new LongestIdealSubsequence_2370();
        l.longestIdealString("pvjcci", 2);
    }
}
