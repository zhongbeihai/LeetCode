package com.dequeue_and_priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Given a string s, sort it in decreasing order based on the frequency of the characters.
// The frequency of a character is the number of times it appears in the string
//Input: s = "tree"
//Output: "eert"
public class SortCharactersByFrequency_451 {
    public String frequencySort(String s) {

        class MyComparator implements Comparator<Map.Entry<Character, Integer>>{

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        }

        HashMap<Character, Integer> count = new HashMap<>();
        // <index, Sequence>
        for(int i = 0; i < s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new MyComparator());
        for(Map.Entry<Character, Integer> e : count.entrySet()){
            pq.add(e);
        }

        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            for(int i = 0; i < pq.peek().getValue(); i++){
                str.append(pq.peek().getKey());
            }
            pq.poll();
        }

        return str.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency_451 s = new SortCharactersByFrequency_451();
        System.out.println(s.frequencySort("cccaaa"));
    }
}
