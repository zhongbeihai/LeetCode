package com.simulation;

public class CheckOneStringSwapCanMakeStringsEqual_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int count = 0;
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++){
           if (s1.charAt(i) != s2.charAt(i)) count++;
           map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++){
            map[s2.charAt(i) - 'a']--;
            if (map[s2.charAt(i) - 'a'] < 0) return false;
        }

        return count == 2;
    }
}
