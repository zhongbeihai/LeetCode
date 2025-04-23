package com.monotonic_stack;

import com.sun.javafx.css.PseudoClassState;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray_581 {
    public int findUnsortedSubarray(int[] nums) {
        int leftBoundary = nums.length;
        int rightBoundary = 0 ;

        Stack<Integer> stack = new Stack<>();

        // to get the left boundary
        for(int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                leftBoundary = Math.min(leftBoundary, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >=0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                rightBoundary = Math.max(rightBoundary, stack.pop());
            }
            stack.push(i);
        }

        return rightBoundary - leftBoundary > 0 ? rightBoundary - leftBoundary + 1 : 0;

    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray_581 s = new ShortestUnsortedContinuousSubarray_581();
        s.findUnsortedSubarray(new int[]{1,3,2,2,2});
    }
}
