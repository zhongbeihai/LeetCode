package com.two_pointers;

import java.util.Arrays;

public class MaxNumberOfKSumPoints {
    public int maxOperations(int[] nums, int k) {
        int head = 0, rear = nums.length - 1, res = 0;
        Arrays.sort(nums);
        while (head < rear){
            if (nums[head] + nums[rear] > k){
                rear--;
            } else if (nums[head] + nums[rear] < k) {
                head++;
            }else {
                res++;
                head++;
                rear--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPoints m = new MaxNumberOfKSumPoints();
        m.maxOperations(new int[]{3,1,3,4,3}, 6);
    }
}
