package com.search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindTheFirstAndLastElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if(Arrays.stream(nums).noneMatch(e -> e == target)) return res;
        int left = 0, right = nums.length - 1;
        while (left < right - 1){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid;
            }else {
                right = mid;
            }
        }


        return res;
    }

    public int findFirstIndex(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        int index = -1;
        while (l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) index = mid;
            if(nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        FindTheFirstAndLastElementInSortedArray_34  f = new FindTheFirstAndLastElementInSortedArray_34();
        //f.searchRange(new int[]{5,7,7,8,8,10}, 8);
        f.searchRange(new int[]{2,2},2);
    }
}
