package com.two_pointers;

import com.divided.QuickSort;

public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            while (left < right && nums[left] % 2 == 0){
                left++;
            }
            while (left < right && nums[right] %2 == 1){
                right--;
            }

            QuickSort.swap(nums, left, right);
        }

        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity_905 s = new SortArrayByParity_905();
        s.sortArrayByParity(new int[]{3,1,2,4});
    }
}
