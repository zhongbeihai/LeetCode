package com.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        int threshold = nums.length / 3;
        HashMap<Integer, Integer> fre = new HashMap<>();
        for (int n: nums){
            fre.put(n, fre.getOrDefault(n, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e: fre.entrySet()){
            if (e.getValue() > threshold) res.add(e.getKey());
        }

        return res;
    }
}
