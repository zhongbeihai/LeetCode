package com.two_pointers;

import java.util.*;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int needCnt = tt.length;
        int[] needFre = new int[120];
        Set<Character> set = new HashSet<>();
        for(char c: tt) {needFre[c]++; set.add(c);}


        int left = 0, len = Integer.MAX_VALUE, l = -1, r = -1;
        for (int right = 0; right < ss.length; right++){

        }

        return l == -1 ? "" : s.substring(l, r + 1);
    }

    public boolean include(Map<Character, Integer> s, Map<Character, Integer> t){
        for (Character c: t.keySet()){
            if (!s.containsKey(c) || s.get(c) < t.get(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_76 m = new MinimumWindowSubstring_76();
        m.minWindow("ADBECEBANC", "ABC");
        // m.minWindow("a", "aa");
    }
}
