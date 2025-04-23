package com.simulation;

public class CountingWordsWithGivenPrefix_2185 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for(String word: words){
            if (word.length() < pref.length()) continue;
            boolean flag = true;
            for(int i = 0; i < pref.length(); i++){
                if(word.charAt(i) != pref.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag) res++;
        }

        return res;
    }
}
