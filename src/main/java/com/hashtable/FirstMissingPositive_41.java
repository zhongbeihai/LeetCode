package com.hashtable;

import com.divided.QuickSort;

import java.util.HashSet;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }

    public boolean swap(int[] nums, int f, int k){
        int tem = nums[f];
        nums[f] = nums[k];
        nums[k] = tem;

        return true;
    }

    public static void main(String[] args) {
        FirstMissingPositive_41 f = new FirstMissingPositive_41();
        f.firstMissingPositive(new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,1});
    }
}
