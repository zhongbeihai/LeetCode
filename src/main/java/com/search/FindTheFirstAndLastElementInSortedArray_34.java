package com.search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindTheFirstAndLastElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (nums.length == 0) return res;

        int rightBound = findFirstBiggerIndex(nums, target - 1);
        if (rightBound == -1 || nums[rightBound] != target) return res;
        else res[0] = rightBound;

        while (rightBound < nums.length - 1 && nums[rightBound] == nums[rightBound + 1]) rightBound++;
        res[1] = rightBound;

        return res;
    }

    public int findFirstBiggerIndex(int[] nums, int target){
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left < nums.length ? left : -1;
    }



    public static void main(String[] args) {
        FindTheFirstAndLastElementInSortedArray_34  f = new FindTheFirstAndLastElementInSortedArray_34();
        // f.searchRange(new int[]{5,7,7,8,8,10}, 8);
        f.searchRange(new int[]{2,2},2);
        //f.searchRange(new int[]{1}, 0);
    }
}
