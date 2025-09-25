package com.search;

public class CheckNumberIsMajorityInSortedArray_1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        // find first smaller place
        int n = nums.length;
        int l = 0, r = nums.length - 1;
        int fs = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target){
                fs = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        // find fist bigger number
        l = 0;
        r = nums.length - 1;
        int fb = n;
        while (l <= r){
            int mid = l + (r - l)  / 2;
            if (nums[mid] > target){
                fb = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }


        return (fb - fs - 1) * 2 > nums.length;
    }

}
