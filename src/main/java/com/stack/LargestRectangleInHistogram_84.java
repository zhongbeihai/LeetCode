package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int idx = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek() ;
                int width = i - left - 1;
                max = Math.max(max, width * heights[idx]);
            }
            stack.push(i);
        }

        int n = heights.length;
        while (!stack.isEmpty()){
            int idx = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = n - left - 1;
            max = Math.max(max, width * heights[idx]);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 l = new LargestRectangleInHistogram_84();
        // l.largestRectangleArea(new int[]{2,1,5,6,2,3});
        l.largestRectangleArea(new int[]{2, 1, 2});
    }
}
