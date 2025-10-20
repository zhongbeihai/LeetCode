package com.dynamic_programming;

import java.util.*;

public class WordBreakII_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        int n = s.length(), minL = Integer.MAX_VALUE, maxL = Integer.MIN_VALUE;
        for (String w: wordDict){
            minL = Math.min(minL, w.length());
            maxL = Math.max(maxL, w.length());
        }

        boolean[] can = new boolean[n + 1];
        for (int i = n - 1; i >= 0; i--){
            for (int j = minL; j <= maxL && i + j <=n; j++){
                if (wordDict.contains(s.substring(i, i + j)) && can[i + j]) {
                    can[i] = true;
                    break;
                }
            }
        }
        if (!can[0]) return new ArrayList<>();

        Map<Integer, List<String>> memo = new HashMap<>();

    }

    public List<String> dfs(int start, Map<Integer, List<String>> memo, String s, Set<String> wordSet,int minL, int maxL, boolean[] can){
        if (memo.containsKey(start)) return memo.get(i);
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (start == n) {
            res.add("");
            memo.put(start, res);
            return res;
        }

        for (int L = minL; L <= maxL && start + L <= n; L++){
            int j = start + L;
            if (!can[j]) continue;

            String singleWord = s.substring(start, j);
            if (!wordSet.contains(singleWord)) continue;
            for (String tail: dfs(j, memo, s, wordSet, minL, maxL, can)){
                String whole = tail.isEmpty() ? singleWord : singleWord + " " + tail;
                res.add(whole);
            }
        }

        memo.put(start, res);
        return res;
    }

}
