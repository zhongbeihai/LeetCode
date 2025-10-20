package com.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII_140 {
    HashSet<String> wordSet;
    List<String>[] memo;
    int[] dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        int n = s.length();
        memo = new List[n];

        return new ArrayList<>();
    }

    public void backtrack(char[] ss, int idx, String sentence, StringBuilder tem){
        if (idx == ss.length){
            if (wordSet.contains(tem.toString())) ans.add(sentence + " " + tem);
            return;
        }

        if (wordSet.contains(tem.toString())){
            sentence = sentence + " " + tem.toString();
        }

        for (int i = idx; i < ss.length; i++) {
            tem.append(ss[i]);


        }
    }
}
