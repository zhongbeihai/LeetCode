package com.dynamic_programming;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, longestCanReach = 0;

        for (int i = 0; i < n; i++) {
            if (longestCanReach >= i) longestCanReach = Math.max(longestCanReach, i + nums[i]);
        }

        return longestCanReach >= n - 1;
    }

    public static void main(String[] args) {
        JumpGame_55 j = new JumpGame_55();
        j.canJump(new int[]{3,2,1,0,4});
    }
}
