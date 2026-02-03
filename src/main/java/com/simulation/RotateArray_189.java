package com.simulation;

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (k == 0) return;

        int mid = len - k;
        reverse(nums, 0, mid - 1);
        reverse(nums, mid, len - 1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int tem = nums[start];
            nums[start] = nums[end];
            nums[end] = tem;
            start++;
            end--;
        }
    }
}
