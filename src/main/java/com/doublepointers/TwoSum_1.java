package com.doublepointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (idxMap.containsKey(target - nums[i])){
                if (idxMap.get(target - nums[i]) != i) return new int[]{i, idxMap.get(target - nums[i])};
            }
            idxMap.put(nums[i], i);
        }

        return new int[]{0,0};
    }

    public static void main(String[] args) {
        TwoSum_1 t = new TwoSum_1();
        t.twoSum(new int[]{3,2,4}, 6);
    }
}
