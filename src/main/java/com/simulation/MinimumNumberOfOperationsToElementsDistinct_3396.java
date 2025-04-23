package com.simulation;

import java.util.HashSet;

public class MinimumNumberOfOperationsToElementsDistinct_3396 {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = n - 1; i >= 0; i++){
            if (set.contains(nums[i])){
                return (int) Math.ceil((double) (i + 1) / 3);
            }
            set.add(nums[i]);
        }


        return 0;
    }
}
