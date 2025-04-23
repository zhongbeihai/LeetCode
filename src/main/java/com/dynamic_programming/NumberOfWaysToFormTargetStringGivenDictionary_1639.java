package com.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class NumberOfWaysToFormTargetStringGivenDictionary_1639 {
    private final int mod = 1_000_000_007;
    public int numWays(String[] words, String target) {
        int[][] frequencies = new int[words[0].length()][26];

        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                frequencies[i][word.charAt(i) - 'a']++;
            }
        }

        int[][] dp = new int[words[0].length()][target.length()];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return recursion(0, 0, frequencies, dp, target);
    }

    public int recursion(int x, int match, int[][] fre, int[][] dp,
                         String target){
        if(match == target.length()){
            return 1;
        }
        if(x == fre.length){
            return 0;
        }
        if(dp[x][match] != -1){
            return dp[x][match];
        }

        long count = recursion(x + 1, match, fre, dp, target);
        count %= mod;
        count += ((long) fre[x][target.charAt(match) - 'a'] * recursion(x + 1, match + 1, fre, dp, target)) % mod;
        count %= mod;
        return dp[x][match] = (int) count;
        }
}
