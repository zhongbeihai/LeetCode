package com.hashtable;

import sun.nio.ch.SelectorImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumLengthOfStringAfterOperations_3223 {
    public int minimumLength(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i), list);
            }else {
                List<Integer> list = map.get(s.charAt(i));
                list.add(i);
            }
        }

        int count = 0;
        for(List<Integer> list: map.values()){
            if(list.size() > 2 && list.size() % 2 == 0) count += 2;
            else if (list.size() > 2) {
                count += 1;
            }else {
                count += list.size();
            }
        }

        return count;
    }
}
