package com.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubseuqnceI_2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String>[] dp = new List[words.length];

        dp[words.length - 1] = new ArrayList();
        dp[words.length - 1].add(words[words.length - 1]);

        for (int i = words.length - 2; i >= 0; i--){
            if (dp[i] == null) dp[i] = new ArrayList();
            dp[i].add(words[i]);
            int idx = i;
            for (int j = i + 1; j < words.length; j++){
                if (groups[j] != groups[i] && dp[j].size() >= dp[idx].size()){
                    idx = j;
                }
            }
            if (idx != i) dp[i].addAll(dp[idx]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubseuqnceI_2900 l= new LongestUnequalAdjacentGroupsSubseuqnceI_2900();
        l.getLongestSubsequence(new String[]{"a", "b","c", "d"}, new int[]{1,0,1,1});
    }
}
