package com.search;

import java.util.Arrays;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= mid){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        MissingNumber_268 m = new MissingNumber_268();
        m.missingNumber(new int[]{0,1,3,4,5});
    }
}
