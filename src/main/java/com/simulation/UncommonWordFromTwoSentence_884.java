package com.simulation;

import java.util.*;

public class UncommonWordFromTwoSentence_884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] ss1 = s1.split("\\s+");
        String[] ss2 = s2.split("\\s+");
        ArrayList<String> l = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : ss1){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : ss2){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : map.keySet()){
            if(map.get(s) == 1){
                l.add(s);
            }
        }
        String[] res = l.toArray(new String[l.size()]);
        return res;
    }

    public static void main(String[] args) {
        UncommonWordFromTwoSentence_884 u = new UncommonWordFromTwoSentence_884();
        u.uncommonFromSentences("this apple is sweet", "this apple is sour");
    }
}
