package com.search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindTheFirstAndLastElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {

        // find from left
        int left = 0, right = nums.length - 1, ld = -1, rd = -1;
        while (left <= right){
            int mid = left + (right - left ) / 2;
            if (nums[mid] == target) ld = mid;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }

        // find from right
        left = 0; right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) rd = mid;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{ld, rd};
    }





    public static void main(String[] args) {
        FindTheFirstAndLastElementInSortedArray_34  f = new FindTheFirstAndLastElementInSortedArray_34();
         f.searchRange(new int[]{5,7,7,8,8,10}, 8);
        // f.searchRange(new int[]{2,2},2);
        //f.searchRange(new int[]{1}, 1);
    }
}
