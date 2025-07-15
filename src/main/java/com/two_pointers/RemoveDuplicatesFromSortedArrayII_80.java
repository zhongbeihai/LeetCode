package com.two_pointers;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 */
public class RemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int i = 2, j = 2;
        while(i < nums.length){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
