package com.dequeue_and_priorityqueue;

import java.util.Arrays;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        int s = count[0] + count[1] + count[2];
        Arrays.fill(nums, 0, count[0], 0);
        Arrays.fill(nums, count[0] + 1, count[0] + count[1], 1);
        Arrays.fill(nums, count[0] + count[1] + 1, s, 2);
    }
}
