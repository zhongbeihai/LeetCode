package com.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()] ){
                stack.push(i);
            }else {
                int height = 0;
                int width = 0;
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    height = heights[stack.pop()];
                    width++;
                    if (height != 0) maxArea = Math.max(maxArea, width * height);
                }
            }
        }

        if (!stack.isEmpty()){
            int width = 0;
            int height = 0;
            while (!stack.isEmpty()) {
                height = heights[stack.pop()];
                width++;
                maxArea = Math.max(maxArea, width * height);
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 l = new LargestRectangleInHistogram_84();
         l.largestRectangleArea(new int[]{2,1,5,6,2,3});
        // l.largestRectangleArea(new int[]{2, 1, 2});
    }
}
