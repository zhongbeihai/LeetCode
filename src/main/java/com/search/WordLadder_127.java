package com.search;


import structure.Pair;

import java.util.*;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        wordSet.remove(beginWord);
        while (!queue.isEmpty()){
            Pair<String, Integer> p = queue.poll();
            String s = p.getKey();
            int count = p.getValue();
            if (s.equals(endWord)) return count;

            for (int i = 0; i < s.length(); i++){
                char[] sArray = s.toCharArray();
                for (char c = 'a'; c <= 'z'; c++){
                    sArray[i] = c;
                    String newString = new String(sArray);
                    if (wordSet.contains(newString)){
                        queue.add(new Pair<>(newString, count+1));
                        wordSet.remove(newString);
                    }
                }
            }
        }

        return 0;
    }
}
