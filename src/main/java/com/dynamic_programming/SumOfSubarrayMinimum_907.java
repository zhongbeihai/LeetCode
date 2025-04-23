package com.dynamic_programming;

import java.util.Stack;

public class SumOfSubarrayMinimum_907 {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            left[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        stack.clear();
        int n = arr.length;
        for (int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            right[i] = (stack.isEmpty()) ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += (long) arr[i] *  left[i] * right[i];
        }
        sum %= 1000000007;
        return (int) sum;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimum_907 s = new SumOfSubarrayMinimum_907();
        s.sumSubarrayMins(new int[]{3,1,2,4,2,4,2});
    }
}
