package com.dequeue_and_priorityqueue;


import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>(); // store index
        int[] res = new int[n - k + 1];

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekLast() < i - k + 1) deque.removeLast();
            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) deque.removeFirst();
            deque.addFirst(i);

            if (i - k + 1 >= 0) res[j++] = nums[deque.peekLast()];
        }

        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum_239 s = new SlidingWindowMaximum_239();
        // s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        s.maxSlidingWindow(new int[]{7,2,4}, 2);
    }
}
