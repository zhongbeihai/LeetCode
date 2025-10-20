package com.systemdesign;

import java.util.*;

public class MagicDictionary {
    private HashMap<Integer, List<String>> map = new HashMap<>();
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String w: dictionary){
            map.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        }
    }

    public boolean search(String searchWord) {
        List<String> list = map.get(searchWord.length());
        if (list == null || list.isEmpty()) return false;

        for (String w: list){
            if (verify(searchWord, w)) return true;
        }

        return false;
    }

    public boolean verify(String word1, String word2){
        int k = 1;

        for (int i = 0; i < word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)) k--;

            if (k < 0) return false;
        }

        return k == 0;
    }

    public static void main(String[] args) {
        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[]{"hello"});
        m.search("hhllo");
    }
}
