package com.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // store the strings that are anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newStr = new String(charArray);
            if (map.get(newStr) == null){
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(newStr, l);
            }else {
                map.get(newStr).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String s = "bat";
        System.out.println();
    }
}
