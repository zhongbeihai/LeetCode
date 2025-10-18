package com.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LeastNumberOfUniqueIntegersAfterKRemovals_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> numToFre = new HashMap<>();
        for (int num: arr) numToFre.put(num, numToFre.getOrDefault(num, 0) + 1);

        int n = numToFre.keySet().size();
        List<Integer> fre = new ArrayList<>(numToFre.values());
        Collections.sort(fre);
        int i = 0;
        while (k > 0){
            k -= fre.get(i++);
            if (k >= 0){
                n--;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals_1481 l = new LeastNumberOfUniqueIntegersAfterKRemovals_1481();
        // l.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3);
        l.findLeastNumOfUniqueInts(new int[]{1}, 1);
    }
}
