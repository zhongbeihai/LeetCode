package com.two_pointers;

import java.util.Map;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int missing = tt.length, left = 0, bestLeft = 0, bestLen = Integer.MAX_VALUE;
        int[] need = new int[128];
        for (char c: tt) need[c]++;

        for (int right = 0; right < ss.length; right++){
            if (need[ss[right]] > 0) missing--;
            need[ss[right]]--;

            while (missing == 0 && left <= right){
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestLeft = left;
                }

                if (need[ss[left]] == 0) missing++;
                need[ss[left]]++;
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLeft + bestLen);
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
