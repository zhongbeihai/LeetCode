package com.doublepointers;

import com.search.MakeLexicographicallySmallestArraybySwappingElements_2948;

import java.util.Arrays;

public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        for (int num: nums){
            int idx = Math.abs(num);
            if (nums[idx] < 0) return idx;
            nums[idx] = -nums[idx];
        }

        return -1;
    }
}
