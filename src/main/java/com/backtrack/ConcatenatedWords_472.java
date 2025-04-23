package com.backtrack;

import javafx.util.Pair;

import java.util.*;

public class ConcatenatedWords_472 {

    private HashSet<String> wordDict;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.wordDict = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            wordDict.remove(word);
            if (canForm(word)) {
                res.add(word);
            }
            wordDict.add(word);
        }

        return res;
    }

    private boolean canForm(String word) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }

    public static void main(String[] args) {
        ConcatenatedWords_472 c = new ConcatenatedWords_472();
        c.findAllConcatenatedWordsInADict(new String[]{"catsdogcats","cat","cats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
    }
}
