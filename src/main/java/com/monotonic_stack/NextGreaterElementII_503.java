package com.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular integer array nums, the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 */
public class NextGreaterElementII_503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);

        for(int i = 0; i < 2 * nums.length; i++){
            int num = nums[ i % nums.length];
            while (!stack.isEmpty() && num > nums[stack.peek()]){
                res[stack.peek()] = num;
                stack.pop();
            }
            if(i < nums.length) stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII_503 x = new NextGreaterElementII_503();
        x.nextGreaterElements(new int[]{1,2,3,4,3});
    }
}
