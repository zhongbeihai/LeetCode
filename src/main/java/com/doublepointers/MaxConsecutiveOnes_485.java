package com.doublepointers;

public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        int max = 0;
        while (right < n){
            if (nums[right] == 0) {
                right++;
                left = right;
                continue;
            }
            while (right < n && nums[right + 1] == 1){
                right++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes_485 m = new MaxConsecutiveOnes_485();
        m.findMaxConsecutiveOnes(new int[]{0});
    }
}
