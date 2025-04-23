package com.simulation;

import java.util.Arrays;

public class CountPrefixAndSuffixPairsI_3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(words[i].length() > words[j].length()) continue;
                if(isPrefixAndSuffix(words[i], words[j])) res++;
            }
        }

        return res;
    }

    boolean isPrefixAndSuffix(String w1, String w2){
        return w2.startsWith(w1) && w2.endsWith(w1);
    }
}
