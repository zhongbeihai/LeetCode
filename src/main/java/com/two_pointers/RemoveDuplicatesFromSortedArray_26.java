package com.two_pointers;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int slowP = 0;
        for(int fastP = slowP + 1; fastP < nums.length; fastP++){
            if(nums[slowP] != nums[fastP]){
                slowP++;
                nums[slowP] = nums[fastP];
            }
        }
        return slowP + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_26 r = new RemoveDuplicatesFromSortedArray_26();
        r.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
