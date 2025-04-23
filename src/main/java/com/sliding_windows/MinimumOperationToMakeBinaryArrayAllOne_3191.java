package com.sliding_windows;

public class MinimumOperationToMakeBinaryArrayAllOne_3191 {
    public int minOperations(int[] nums) {
        int left = 0, right = left + 2;
        int count = 0;
        while (right < nums.length){
            if(nums[left] == 0){
                nums[left] ^= 1;
                nums[left + 1] ^= 1;
                nums[left + 2] ^= 1;
                count++;
            }

            while (nums[left] == 1 && right < nums.length){
                left++;
                right++;
            }
        }

        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0 || nums[nums.length - 3] == 0) return -1;
        else return count;
    }

    public static void main(String[] args) {
        MinimumOperationToMakeBinaryArrayAllOne_3191 m = new MinimumOperationToMakeBinaryArrayAllOne_3191();
        m.minOperations(new int[]{1,0,0,1,1,0,1,1,1});
    }
}
