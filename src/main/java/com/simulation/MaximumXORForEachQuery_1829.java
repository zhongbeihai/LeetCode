package com.simulation;

public class MaximumXORForEachQuery_1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xs = 0;
        for(int num: nums){
            xs ^= num;
        }
        int mask = (1 << maximumBit) - 1;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int x= nums[nums.length - i - 1];
            int k = xs ^ mask;
            ans[i] = k;
            xs ^= x;
        }

        return ans;
    }
}
