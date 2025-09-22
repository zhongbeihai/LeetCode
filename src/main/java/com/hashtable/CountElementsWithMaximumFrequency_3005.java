package com.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency_3005 {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        int maxFre = 0, c = 0;
        for (int num: nums){
            int f = fre.getOrDefault(num, 0) + 1;
            fre.put(num, f);
            if (f > maxFre){
                maxFre = f;
                c = 1;
            } else if (f == maxFre) {
                c++;
            }
        }

        return maxFre * c;
    }
}
