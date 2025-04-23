package com.simulation;

import com.dynamic_programming.CountWayToBuildGoodStrings_2466;
import com.dynamic_programming.Count_Increasing_Quadruplets_2552;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CountVowelStringsInRange_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Character[] vo = new Character[]{'a','e','i','o','u'};
        HashSet<Character> vowel = new HashSet<>(Arrays.asList(vo));

        boolean[] isVowel = new boolean[words.length];
        int[] count = new int[words.length + 1];
        for(int i = 1; i <= words.length; i++){
            String word = words[i - 1];
            char f = word.charAt(0);
            char l = word.charAt(word.length() - 1);
            if(vowel.contains(f) && vowel.contains(l)) {
                isVowel[i - 1] = true;
                count[i] = count[i - 1] + 1;

            }else {
                count[i] = count[i - 1];
            }
        }

        int[] res = new int[queries.length];
        for(int j = 0; j < queries.length; j++){
            res[j] = count[queries[j][1] + 1] - count[queries[j][0]];
        }

        return res;
    }

    public static void main(String[] args) {
        CountVowelStringsInRange_2559 c = new CountVowelStringsInRange_2559();
        c.vowelStrings(new String[]{"a","e","i"}, new int[][]{{0,2},{0,1},{2,2}});
    }
}
