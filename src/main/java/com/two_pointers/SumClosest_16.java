package com.two_pointers;

import java.util.*;

public class SumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int sum = 0;
        int gap = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int curSum = nums[i] + nums[left] + nums[right];
                if(curSum == target) return curSum;
                int curGap = Math.abs(curSum - target);
                if(curGap < gap) {
                    gap = curGap;
                    sum = curSum;
                }
                if(curSum > target){
                    right--;
                }else {
                    left++;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        SumClosest_16 s = new SumClosest_16();
        s.threeSumClosest(new int[]{-4,0,5,-5,3,3,0,-4,-5}, -2);
    }
}
