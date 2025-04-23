package com.monotonic_stack;

import java.util.Stack;

public class SumOfSubarrayRanges_2104 {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] rightBound = new int[n];
        int[] leftBound = new int[n];
        int leftSum = 0, rightSum = 0;
        long sum = 0;

        for (int i = 0; i <= n; i++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int j = stack.pop();
                
            }
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            leftBound[i] = (stack.isEmpty()) ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++){
            sum += nums[i] * (rightBound[i] - leftBound[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfSubarrayRanges_2104 s = new SumOfSubarrayRanges_2104();
        s.subArrayRanges(new int[]{4,-2,-3,4,1});
    }
}
