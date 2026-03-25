package com.binary_tree;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int turnPoint = 0;
        while (turnPoint < n){
            if (turnPoint - 1 >= 0 && nums[turnPoint - 1] > nums[turnPoint]) break;
            turnPoint++;
        }

        int left = 0, right = turnPoint;
        // do binary search from 0 - turn point;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        if (turnPoint == n) return -1;

        left  = turnPoint;
        right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 s= new SearchInRotatedSortedArray_33();
        // s.search(new int[]{4,5,6,7,0,1,2}, 0);
        // s.search(new int[]{3, 1}, 3);
        s.search(new int[]{1}, 0);
    }
}
