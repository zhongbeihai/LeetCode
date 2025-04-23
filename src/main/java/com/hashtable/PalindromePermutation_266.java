package com.hashtable;

public class PalindromePermutation_266 {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[26];
        char[] ss = s.toCharArray();

        for (char c: ss){
            map[c - 'a']++;
        }
        int oddCount = 0;
        for (int m: map){
            if (m % 2 == 1) oddCount++;
            if (oddCount > 1) return false;
        }

        return true;
    }
}
