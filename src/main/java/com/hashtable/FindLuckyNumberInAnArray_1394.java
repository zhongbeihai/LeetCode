package com.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyNumberInAnArray_1394 {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> fre = new HashMap<>();

        for (int i: arr){
            fre.put(i, fre.getOrDefault(i, 0) + 1);
        }

        int res = -1;
        for (Map.Entry<Integer, Integer> e: fre.entrySet() ){
            if (e.getKey().intValue() == e.getValue().intValue()) res = Math.max(res, e.getKey());
        }

        return res;
    }
}
