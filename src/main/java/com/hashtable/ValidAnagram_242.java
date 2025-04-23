package com.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        IntStream.range(0, ss.length).forEach(i -> {
            map.put(ss[i], map.getOrDefault(ss[i], 0) + 1);
            map.put(tt[i], map.getOrDefault(tt[i], 0) - 1);
        });

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if (e.getValue() != 0 )
                return false;
        }
        return true;
    }
}
