package com.dynamic_programming;

import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int k){
        int n = nums.length;
        int low = 0, high = 0;
        for (int num : nums) high += num;

        int res = Integer.MAX_VALUE;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (isSubarrayThanK(nums, mid, k)){
                high = mid;
                res = Math.min(res, high);
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isSubarrayThanK(int[] nums, int mid, int k){
        int step = 1, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i];
            if (cnt > mid){
                cnt = nums[i];
                step++;
            }

            if (cnt > mid || step > k) return false;
        }

        return step<= k;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum_410 s = new SplitArrayLargestSum_410();
        // s.splitArray(new int[]{7,2,5,10,8}, 2);
 //       s.isSubarrayThanK(new int[]{7,2,5,10,8}, 20, 2);
       // s.splitArray(new int[]{1,2,3,4,5}, 1);
        s.splitArray(new int[]{1,4,4}, 3);
    }
}
