package com.simulation;

import java.util.*;

public class MaximumProductOfThreeNumbers_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int p1 = 1, n = nums.length;
        for (int i = n - 1; i >= n - 3; i++){
            p1 *= nums[i];
        }

        int p2 = nums[n - 1];
        for (int i = 0; i < 2; i++) p2 *= nums[i];

        return Math.max(p1, p2);
    }
}
