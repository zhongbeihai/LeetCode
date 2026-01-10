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
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()){
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        ValidAnagram_242 v = new ValidAnagram_242();
        v.isAnagram("anagram", "nagaram");
    }
}
