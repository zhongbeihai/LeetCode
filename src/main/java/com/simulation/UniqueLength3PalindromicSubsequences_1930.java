package com.simulation;

import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences_1930 {
    public int countPalindromicSubsequence(String s) {
        int[] toRight = new int[26];
        for(char c: s.toCharArray()){
            toRight[c - 'a']++;
        }

        int[] toLeft = new int[26];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - 'a';
            toRight[cur]--;
            for(int j = 0; j < 26; j++){
                if(toRight[j] > 0 && toLeft[j] > 0){
                    set.add(26 * cur + j);
                }
            }
            toLeft[cur]++;
        }

        return set.size();
    }
}
