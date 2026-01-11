package com.hashtable;

import java.util.HashSet;
import java.util.Set;

public class RemoveLetterToEqualizeFrequence_2423 {
    public boolean equalFrequency(String word) {
        int[] fre = new int[26];
        for (char c: word.toCharArray()){
            fre[c - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            fre[i]--;
            if (isValid(fre)) return true;
            fre[i]++;
        }

        return false;
    }

    public boolean isValid(int[] fre){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (fre[i] != 0) set.add(fre[i]);
        }

        return set.size() == 1;
    }

    public static void main(String[] args) {
        RemoveLetterToEqualizeFrequence_2423 r = new RemoveLetterToEqualizeFrequence_2423();
        r.equalFrequency("abcc");
    }
}
