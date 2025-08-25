package com.two_pointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tfre = new HashMap<>();
        Map<Character, Integer> sfre = new HashMap<>();
        char[] tt = t.toCharArray();
        char[] ss = s.toCharArray();
        for (char c: tt){
            tfre.put(c, tfre.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, n = s.length();
        String res = s + "null";
        for (right = 0; right < n; right++){
            sfre.put(ss[right], sfre.getOrDefault(ss[right], 0) + 1);
            while (include(sfre, tfre) && left <= right){
                if (right - left + 1 < res.length()) res = s.substring(left, right + 1);
                sfre.put(ss[left], sfre.get(ss[left]) - 1);
                left++;
            }
        }

        return !res.equals(s + "null") ? res : "";
    }

    public boolean include(Map<Character, Integer> s, Map<Character, Integer> t){
        for (Character c: t.keySet()){
            if (!s.containsKey(c) || s.get(c) < t.get(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_76 m = new MinimumWindowSubstring_76();
        // m.minWindow("ADOBECODEBANC", "ABC");
        m.minWindow("a", "aa");
    }
}
