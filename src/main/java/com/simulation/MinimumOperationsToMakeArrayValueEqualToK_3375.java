package com.simulation;

import java.util.HashSet;
import java.util.TreeSet;

public class MinimumOperationsToMakeArrayValueEqualToK_3375 {
    public int minOperations(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();

        int min = Integer.MAX_VALUE;
        for (int num: nums){
            if (num < k) return -1;
            set.add(num);
            min = Math.min(min, num);
        }

        if (k < min) return set.size();
        else return set.size() - 1;
    }
}
