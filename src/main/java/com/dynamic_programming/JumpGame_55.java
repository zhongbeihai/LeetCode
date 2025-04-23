package com.dynamic_programming;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        //dp[i] the longest pos can reach at i
        int[] dp =  new int[nums.length];
        int maxPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxPos >= i){
                dp[i] = i + nums[i];
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            if(maxPos >= nums.length - 1) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGame_55 j = new JumpGame_55();
        j.canJump(new int[]{3,2,1,0,4});
    }
}
