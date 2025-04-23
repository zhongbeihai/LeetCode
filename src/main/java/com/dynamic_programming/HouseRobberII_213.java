package com.dynamic_programming;

public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums.length <= 1) return nums.length ==0 ? 0 : nums[0];
        return Math.max(rob(nums,0, nums.length -1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int left, int right){
        int rob = 0, notRob = 0;
        for(int i = left; i < right; i++){
            int preRob = rob, preNotRob = notRob;
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);
        }
        return Math.max(rob, notRob);
    }

}
