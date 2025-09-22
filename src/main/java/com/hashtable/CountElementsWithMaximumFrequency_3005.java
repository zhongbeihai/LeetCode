package com.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency_3005 {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        int maxFre = 0, c = 0;
        for (int num: nums){
            fre.put(num, fre.getOrDefault(num, 0) + 1);
            if (fre.get(num) > maxFre){
                maxFre = fre.get(num);
                c = 1;
            } else if (fre.get(num) == maxFre) {
                c++;
            }
        }

        return maxFre * c;
    }
}
