package com.two_pointers;

import java.util.TreeSet;

public class FruitsIntoBasketsIII_3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < baskets.length; i++) {
            available.add(i);
        }

        int unplaced = fruits.length;
        for (int fruit: fruits){
            Integer leftMost = available.first();
            while (leftMost != null && baskets[leftMost] < fruit){
                // available.remove(leftMost);
                leftMost = available.higher(leftMost);
            }
            if (leftMost == null){
                unplaced++;
            }else {
                available.remove(leftMost);
            }
        }

        return unplaced;
    }
}
