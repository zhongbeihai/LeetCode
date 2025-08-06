package com.two_pointers;

import java.util.TreeSet;

public class FruitsIntoBasketsIII_3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < baskets.length; i++) {
            available.add(i);
        }

        int unplaced = fruits.length;
        for (int fruit: fruits){
            for (int idx: available){
                if (baskets[idx] >= fruit){
                    available.remove(idx);
                    unplaced--;
                    break;
                }
            }
        }

        return unplaced;
    }
}
