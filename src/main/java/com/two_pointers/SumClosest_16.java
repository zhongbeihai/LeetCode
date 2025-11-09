package com.two_pointers;

import java.util.*;

public class SumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < minDiff){
                    minSum = sum;
                    minDiff = Math.abs(sum - target);
                }
                if (sum == target) return sum;
                else if (sum > target){
                    right--;
                }else {
                    left++;
                }
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        SumClosest_16 s = new SumClosest_16();
        s.threeSumClosest(new int[]{-4,0,5,-5,3,3,0,-4,-5}, -2);
    }
}
