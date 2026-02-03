package com.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] heightsArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            heightsArr[i] = heights[i];
        }
        heightsArr[n] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && heightsArr[i] < heightsArr[stack.peek()]) {
                int idx = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int heigh = heightsArr[idx];
                maxArea = Math.max(maxArea, width * heigh);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 l = new LargestRectangleInHistogram_84();
        l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        // l.largestRectangleArea(new int[]{2, 1, 2});
    }
}
