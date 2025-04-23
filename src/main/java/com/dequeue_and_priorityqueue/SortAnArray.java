package com.dequeue_and_priorityqueue;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l > r) return;
        int pivot = nums[(l + r) / 2];
        int i = l, j = r;
        while (l < r) {
            while (l < r && nums[r] > pivot){
                r--;
            }
            if(l < r) nums[l++] = nums[r];
            while (l < r && nums[l] < pivot){
                l++;
            }
            if(l < r) nums[r--] = nums[l];
        }
        nums[l] = pivot;
        quickSort(nums, i, l - 1);
        quickSort(nums, l + 1, j);
    }
}
