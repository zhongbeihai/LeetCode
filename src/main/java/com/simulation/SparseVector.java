package com.simulation;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    HashMap<Integer, Integer> map;

    SparseVector(int[] nums) {
        this.map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) map.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int aum = 0;
        for (Map.Entry<Integer, Integer> entry: this.map.entrySet()){
            aum += vec.map.getOrDefault(entry.getKey(), 0) * entry.getValue();
        }

        return aum;
    }
}
