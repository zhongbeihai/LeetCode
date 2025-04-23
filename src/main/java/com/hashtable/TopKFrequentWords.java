package com.hashtable;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> l = new ArrayList<>(map.entrySet());
        l.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(Objects.equals(o1.getValue(), o2.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(l.get(i).getKey());
        }

        return res;
    }
}
