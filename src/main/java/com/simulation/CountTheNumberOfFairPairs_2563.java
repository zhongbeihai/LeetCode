package com.simulation;

import structure.Pair;

import java.util.Arrays;

public class CountTheNumberOfFairPairs_2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int lowIn = i, highIn = nums.length - 1;

            while (nums[highIn] + nums[i] > upper && highIn > i) {
                highIn--;
            }
            while (nums[lowIn] + nums[i] < lower && lowIn < nums.length - 1) {
                lowIn++;
            }
            if(nums[i] + nums[lowIn] < lower || nums[i] + nums[highIn] > upper) continue;
            ans += highIn - lowIn + 1;
        }

        return ans;
    }

    public int getIndexOfFirstLessNum(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while (l < r - 1 ){
            int mid = (l + r) / 2;
            if (nums[mid] <= target){
                l = mid;
            }else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        CountTheNumberOfFairPairs_2563 c = new CountTheNumberOfFairPairs_2563();
        int[] nums = new int[]{1,7,9,2,5};
        Arrays.sort(nums);
        c.countFairPairs(nums, 11, 11);
    }
}
