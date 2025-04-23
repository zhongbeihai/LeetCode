package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        // dp[i] means if pre ith letters con be consisted of by wordDict
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < s.length(); i++){
            for(String word: wordDict){
                int len = word.length();
                if( (i + 1) < len) continue;
                String str = s.substring(i - len  + 1, i + 1);
                if (word.equals(str) && dp[i - len  + 1]) {
                    dp[i + 1] = true;
                    break;
                }
            }

        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak_139 w = new WordBreak_139();
        ArrayList<String> l =  new ArrayList<>();
        l.add("leet");
        l.add("code");
        w.wordBreak("leetcode", l);
    }
}
