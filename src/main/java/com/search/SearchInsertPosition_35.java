package com.search;

public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition_35 s = new SearchInsertPosition_35();
        s.searchInsert(new int[]{1,3,5,6}, 5);
    }
}
