package com.sliding_windows;

import java.util.HashMap;
import java.util.HashSet;

public class ContainDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numToIdx = new HashMap<>();

        boolean flag = false;
        for (int i = 0; i < nums.length; i++){
            if (numToIdx.containsKey(nums[i])){
                flag = i - numToIdx.get(nums[i]) <= k;
            }
            if (flag) return flag;

            numToIdx.put(nums[i], i);
        }

        return false;
    }
}
