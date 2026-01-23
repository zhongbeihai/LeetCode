package com.dynamic_programming;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, maxReach = 0;

        for (int i = 0; i < n; i++) {
            if (maxReach < i) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return maxReach >= n - 1;
    }

    public static void main(String[] args) {
        JumpGame_55 j = new JumpGame_55();
        j.canJump(new int[]{3,2,1,0,4});
    }
}
