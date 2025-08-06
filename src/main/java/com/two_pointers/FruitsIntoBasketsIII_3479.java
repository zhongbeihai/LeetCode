package com.two_pointers;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FruitsIntoBasketsIII_3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(baskets[i], k -> new TreeSet<Integer>()).add(i);
        }

        int unplaced = 0;
        for (int fruit: fruits){
            Integer ceilingKey = map.ceilingKey(fruit);
            if (ceilingKey == null){
                unplaced++;
                continue;
            }

            TreeSet<Integer> indices = map.get(ceilingKey);
            int leftMost = indices.first();
            indices.remove(leftMost);
            if (indices.isEmpty()){
                map.remove(ceilingKey);
            }
        }

        return unplaced;
    }
}
