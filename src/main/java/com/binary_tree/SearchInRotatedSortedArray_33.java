package com.binary_tree;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = 0, right = n, model = nums[0];
        while (pivot < right){
            int mid = pivot + (right - pivot) / 2;
            if (nums[mid] >= model) {
                pivot = mid + 1;
            }else {
                right = mid;
            }
        }

        int l, h;
        if (pivot == n){
            l = 0; h = n - 1;
        } else if (target >= model) {
            l = 0; h = pivot - 1;
        }else {
            l = pivot; h = n - 1;
        }

        while (l <= h){
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target){
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 s= new SearchInRotatedSortedArray_33();
        // s.search(new int[]{4,5,6,7,0,1,2}, 0);
         s.search(new int[]{1, 3}, 0);
    }
}
