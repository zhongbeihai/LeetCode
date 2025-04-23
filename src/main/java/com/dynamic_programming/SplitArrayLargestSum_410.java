package com.dynamic_programming;

import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int k){
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        int res = Integer.MAX_VALUE;
        while (low < high){
            int mid = (high + low) / 2;
            if (isSubarrayThanK(nums, mid, k)){
                low = mid + 1;
            } else {
                high = mid;
                res = Math.min(res, high);
            }
        }

        return high;
    }

    public boolean isSubarrayThanK(int[] nums, int mid, int k){
        int splitSum = 0;
        int split = 1;
        for (int num : nums) {
            if (splitSum + num > mid) { // 如果当前子数组的和超过 mid，才需要分割
                splitSum = num;
                split++;
            } else {
                splitSum += num;
            }
        }
        return split > k;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum_410 s = new SplitArrayLargestSum_410();
//        s.isSubarrayThanK(new int[]{7,2,5,10,8}, 20, 2);
        s.splitArray(new int[]{1,2,3,4,5}, 1);
        // s.splitArray(new int[]{1,4,4}, 3);
    }
}
