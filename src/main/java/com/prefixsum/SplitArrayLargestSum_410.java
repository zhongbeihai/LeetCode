package com.prefixsum;

import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int k){
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        int maxx = high;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(isValid(nums, mid, k)){
                maxx = Math.min(maxx, mid);
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return maxx;
    }

    public boolean isValid(int[] nums, int mid, int k){
        int sum = 0;
        int split = 1;
        for (int num : nums) {
            if (sum + num < mid) {
                sum += num;
            } else {
                sum = num;
                split++;
            }
        }

        return split <= k;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum_410 s= new SplitArrayLargestSum_410();

    }
}
