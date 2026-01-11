package com.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Given a circular integer array nums, the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 */
public class NextGreaterElementII_503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n * 2; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                res[stack.pop()] = nums[idx];
            }

            if (i < n) stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII_503 x = new NextGreaterElementII_503();
        x.nextGreaterElements(new int[]{1,2,3,4,3});
    }
}
