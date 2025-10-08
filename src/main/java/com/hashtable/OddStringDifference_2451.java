package com.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddStringDifference_2451 {
    public String oddString(String[] words) {
        HashMap<List<Integer>, Integer> diffToFre = new HashMap<>();// <difference, freq>
        HashMap<List<Integer>, String> diffToString = new HashMap<>();
        for (String word: words){
            List<Integer> diff = new ArrayList<>();
            for (int i = 1; i < word.length(); i++){
                diff.add(word.charAt(i) - word.charAt(i - 1));
            }
            diffToFre.put(diff, diffToFre.getOrDefault(diff, 0) + 1);
            diffToString.put(diff, word);
        }

        for (Map.Entry<List<Integer>, Integer> e: diffToFre.entrySet()){
            if (e.getValue() == 1){
                return diffToString.get(e.getKey());
            }
        }

        return "";
    }
}
