package com.systemdesign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SparseVector {
    public HashMap<Integer, Integer> indexToVal = new HashMap<>();
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) indexToVal.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> e: this.indexToVal.entrySet()){
            if (vec.indexToVal.containsKey(e.getKey())) sum += vec.indexToVal.get(e.getKey()) * e.getValue();
        }

        return sum;
    }
}
