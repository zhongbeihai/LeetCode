package com.two_pointers;

import java.util.Map;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[126];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int missing = tt.length;
        for (char c: tt) need[c]++;

        int left = 0, bestLeft = -1, bestLen = Integer.MAX_VALUE;
        for (int right = 0; right < ss.length; right++){
            char cur = ss[right];
            if (need[cur] > 0) missing--;
            need[cur]--;

            while (missing == 0 && left <= right){
                if (right - left + 1 < bestLen){
                    bestLen = right - left + 1;
                    bestLeft = left;
                }
                need[ss[left]]++;
                if (need[ss[left]] > 0) missing++;
                left++;
            }
        }

        return bestLeft != - 1 ? s.substring(bestLeft, bestLeft + bestLen) : "";
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
