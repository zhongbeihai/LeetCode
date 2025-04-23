package com.sliding_windows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class FruitIntoBasket_904 {
    public int totalFruit(int[] fruits) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int leftType = fruits[0];
        for (int right = 0; right < fruits.length; right++){
            if (map.size() == 2 && !map.containsKey(fruits[right])){
                map.remove(leftType);
                leftType = map.keySet().iterator().next();
            }
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            int cur = 0;
            for (int i: map.values()){
                cur += i;
            }
            res = Math.max(cur, res);
        }

        return res;
    }

    public static void main(String[] args) {
        FruitIntoBasket_904 f= new FruitIntoBasket_904();
        f.totalFruit(new int[]{1,0,1,4,1,4,1,2,3});
    }
}
