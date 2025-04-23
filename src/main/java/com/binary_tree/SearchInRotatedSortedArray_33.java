package com.binary_tree;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int  n = nums.length, turningPoint = n;
        int p = 0;
        while (p + 1< n){
            if (nums[p + 1] < nums[p]) {
                turningPoint= p + 1;
                break;
            }
            p++;
        }

        int low = 0, high = n - 1;
        if (target >= nums[0] && target <= nums[turningPoint - 1]) high = turningPoint - 1;
        else low = turningPoint ;

        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 s= new SearchInRotatedSortedArray_33();
        // s.search(new int[]{4,5,6,7,0,1,2}, -1);
        s.search(new int[]{1}, 1);
    }
}
