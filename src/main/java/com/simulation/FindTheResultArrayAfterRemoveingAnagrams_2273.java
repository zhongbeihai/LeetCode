package com.simulation;

import java.util.*;

public class FindTheResultArrayAfterRemoveingAnagrams_2273 {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        int i = 0, j = i + 1;

        List<String> res = new ArrayList<>();
        while (i < n){
            char[] word = words[i].toCharArray();
            Arrays.sort(word);
            String ana = String.valueOf(word);
            res.add(words[i]);

            while (j < n){
                char[] wordJ = words[j].toCharArray();
                Arrays.sort(wordJ);
                if (ana.equals(String.valueOf(wordJ))) j++;
                else break;
            }
            i = j;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        FindTheResultArrayAfterRemoveingAnagrams_2273 f = new FindTheResultArrayAfterRemoveingAnagrams_2273();
        f.removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"});
    }
}
