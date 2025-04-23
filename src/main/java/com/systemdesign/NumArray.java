package com.systemdesign;

public class NumArray {
    private int[] nums;
    private int[] prefixSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int[nums.length + 1];
        this.prefixSum[0] = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            this.prefixSum[i+1] = sum;
        }
    }

    public void update(int index, int val) {
        this.nums[index] = val;
        int sum = prefixSum[index];
        for(int i = index; i < nums.length; i++) {
            sum += nums[i];
            this.prefixSum[i+1] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return this.prefixSum[right+1] - this.prefixSum[left];
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{1,3,5});

        int param_1 = obj.sumRange(0,2);
        obj.update(1,2);
        int param_2 = obj.sumRange(0,2);
    }
}
