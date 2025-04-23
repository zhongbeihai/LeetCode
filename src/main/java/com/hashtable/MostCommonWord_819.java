package com.hashtable;

import java.util.*;

public class MostCommonWord_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("\\W");
        HashMap<String, Integer> map = new HashMap<>();
        List<String> banList = Arrays.asList(banned);
        for(String word: words) {
            word = word.toLowerCase();
            if(!banList.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        map.clear();
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        return list.get(0).getKey();
    }

    public static void main(String[] args) {
        MostCommonWord_819 m = new MostCommonWord_819();
        m.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
    }

}
