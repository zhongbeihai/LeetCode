package com.two_pointers;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed.
 * Then return the number of elements in nums which are not equal to val.
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 */
public class RemoveElement_27 {

    public int removeElement(int[] nums, int val) {
        int slowP = 0, cnt = 0; // point to the first position where can hold valid position

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[slowP] = nums[i];
                slowP++;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        RemoveElement_27 r = new RemoveElement_27();
        r.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }

}
