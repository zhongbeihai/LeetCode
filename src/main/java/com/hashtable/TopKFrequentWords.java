package com.hashtable;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> fre = new HashMap<>();
        for (String w: words){
            fre.put(w, fre.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((i, j) -> {
            if (Objects.equals(i.getValue(), j.getValue())) return -i.getKey().compareTo(j.getKey());
            return i.getValue() - j.getValue();
        });
        for (Map.Entry<String, Integer> e: fre.entrySet()){
            pq.add(e);
            while (pq.size() > k) pq.poll();
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll().getKey());
        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords t = new TopKFrequentWords();
        t.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2);
    }
}
