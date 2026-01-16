package com.hashtable;

public class MinimumStepsToMakeTwoStringAnagram_1347 {
    public int minSteps(String s, String t) {
        int[] fre = new int[26];

        for (int i = 0; i < s.length(); i++) {
            fre[s.charAt(i) - 'a']++;
            fre[t.charAt(i) - 'a']--;
        }


        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (fre[i] < 0) res += -fre[i];
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumStepsToMakeTwoStringAnagram_1347 m = new MinimumStepsToMakeTwoStringAnagram_1347();
        m.minSteps("leetcode", "practice");
    }
}
