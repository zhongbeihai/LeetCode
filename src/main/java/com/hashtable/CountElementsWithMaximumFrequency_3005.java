package com.hashtable;

import java.util.HashMap;

public class CountElementsWithMaximumFrequency_3005 {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        int maxFre = 0;
        for (int num: nums){
            fre.put(num, fre.getOrDefault(num, 0) + 1);
            maxFre = Math.max(maxFre, fre.get(num));
        }
    }
}
