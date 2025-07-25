package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumSubarraySumAfterDeletion_3487 {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int curSum = 0, maxElement = Integer.MIN_VALUE;

        for (int num: nums){
            if (num > 0 && !set.contains(num)) {
                curSum += num;
                set.add(num);
                maxElement = Math.max(maxElement, num);
            }
        }

        if (curSum == 0) return maxElement;
        return curSum;
    }
}
