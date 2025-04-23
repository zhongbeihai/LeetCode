package com.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordSubsets_916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCount = new int[26];

        for(String word2: words2){
            int[] count = new int[26];
            for(char c: word2.toCharArray()){
                count[c - 'a']++;
            }

            for (int i = 0; i < 26; ++i){
                maxCount[i] = Math.max(maxCount[i], count[i]);
            }
        }

        List<String > res = new ArrayList<>();
        for(String word1: words1){
            boolean flag = true;
            int[] count1 = new int[26];
            for(char c: word1.toCharArray()){
                count1[c - 'a']++;
            }

            for(int i = 0; i < 26; i++){
                if(maxCount[i] == 0) continue;
                if(count1[i] < maxCount[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(word1);
        }

        return res;
    }

    public static void main(String[] args) {
        WordSubsets_916 w = new WordSubsets_916();

        String[] words1 = new String[]{"apple", "google","leetcode"};
        String[] words2 = new String[]{"lo","eo"};
        w.wordSubsets(words1, words2);
    }
}
