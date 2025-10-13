package com.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String anagram = String.valueOf(c);
            map.computeIfAbsent(anagram, v -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String s = "bat";
        System.out.println();
    }
}
