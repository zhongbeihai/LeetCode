package com.doublepointers;

import java.util.Arrays;

/**
 * Input: nums = [0,1,0,3,12]
 * 1 3 0 0 12
 * Output: [1,3,12,0,0]
 */
public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        int slowP = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[slowP];
                nums[slowP] = nums[i];
                nums[i] = temp;
                slowP++;
            }
        }
    }

}
