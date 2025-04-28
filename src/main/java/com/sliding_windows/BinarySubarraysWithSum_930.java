package com.sliding_windows;

public class BinarySubarraysWithSum_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return find(nums, goal) - find(nums, goal - 1);
    }

    public int find(int[] nums, int goal){
        if (goal < 0) return 0;
        int left = 0, n = nums.length, res = 0;
        int curSum = 0;

        for (int right = 0; right < n; right++){
            curSum += nums[right];


            while (curSum > goal){
                curSum -= nums[left];
                left++;
            }

            res += right - left + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum_930 n = new BinarySubarraysWithSum_930();
        n.numSubarraysWithSum(new int[]{0,0,0,0,0},0);
    }
}
