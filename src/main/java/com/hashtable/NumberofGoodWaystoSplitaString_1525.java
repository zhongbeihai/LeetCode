package com.hashtable;

import java.util.HashMap;

public class NumberofGoodWaystoSplitaString_1525 {
    public int numSplits(String s) {
        HashMap<Character, Integer> right = new HashMap<>();
        HashMap<Character, Integer> left = new HashMap<>();
        int cnt = 0;
        for(char c : s.toCharArray()){
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        for(char c : s.toCharArray()){
            left.put(c, left.getOrDefault(c, 0) + 1);
            right.put(c, right.get(c) - 1);
            if(right.get(c) == 0) right.remove(c);
            if(left.keySet().size() == right.keySet().size()) cnt++;
        }
        return cnt;
    }
}
