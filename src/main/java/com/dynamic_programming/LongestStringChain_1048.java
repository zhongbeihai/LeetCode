package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestStringChain_1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (e1, e2) -> e1.length() - e2.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for(String word: words){
            int curLen = 1;
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                if(dp.containsKey(sb.toString())){
                    curLen = Math.max(curLen, dp.get(sb.toString()) + 1);
                }
            }
            dp.put(word, curLen);
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    public boolean isPredecessor(String s, String p){
        if(s.length() == p.length() && !s.equals(p)) return false;
        int p1 = 0, p2 = 0;
        if(s.length() - p.length() > 1) return false;
        int cnt = 0;
        while (p1 < s.length()){
            if(s.charAt(p1) == p.charAt(p2)) {
                p1++;
                p2++;
            }else {
                p2++;
                cnt++;
                if(cnt > 1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LongestStringChain_1048 l = new LongestStringChain_1048();
        l.longestStrChain(new String[]{"a","ac","ab","bd","abd","abc","abdd"});
    }
}
