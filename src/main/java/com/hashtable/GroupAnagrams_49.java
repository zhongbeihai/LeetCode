package com.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            map.computeIfAbsent(String.valueOf(strArr), v ->  new ArrayList<String>()).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());

        return res;
    }

    public static void main(String[] args) {
        String s = "bat";
        System.out.println();
    }
}
