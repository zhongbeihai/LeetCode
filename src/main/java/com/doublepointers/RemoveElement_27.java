package com.doublepointers;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed.
 * Then return the number of elements in nums which are not equal to val.
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 */
public class RemoveElement_27 {

    // fast-slow pointers algorithm
    // which is used to
    public int removeElement(int[] nums, int val) {
        int slowP = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[slowP] = nums[i];
                slowP++;
            }
        }
        return slowP;
    }

}
