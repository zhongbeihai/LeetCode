package com.sliding_windows;

import java.util.HashSet;

public class ContainDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if (i - left >= k){
                set.remove(nums[left]);
                left++;
            }
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }
}
