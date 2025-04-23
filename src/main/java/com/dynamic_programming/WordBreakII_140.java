package com.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII_140 {

    private HashSet<String> wordDict;
    private List<String>[] memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        memo = new List[s.length()];
        return dp(s, 0);
    }

    List<String> dp(String s, int start ){
        List<String> res = new ArrayList<>();
        if(start == s.length()){
            res.add("");
            return res;
        }

        if(memo[start] != null) return memo[start];

        for(int i = 1; i + start<= s.length(); i++){
            String prefix = s.substring(start, start + i);
            if(wordDict.contains(prefix)){
                List<String> subProblem = dp(s, start + i);
                for (String sub: subProblem){
                    if(sub.isEmpty()){
                        res.add(prefix);
                    }else {
                        res.add(prefix + " " + sub);
                    }
                }
            }
        }

        memo[start] = res;
        return res;
    }
}
