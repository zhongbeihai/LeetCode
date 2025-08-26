package com.simulation;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbosultDiffLessThanLimit_1438 {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 0) return 0;

        Deque<Integer> minq = new ArrayDeque<>();
        Deque<Integer> maxq = new ArrayDeque<>();

        int left = 0, n = nums.length, res = 1;
        for (int right = 0; right < n; right++){
            while (!minq.isEmpty() && nums[right] > nums[minq.peekLast()]) minq.pollLast();
            minq.addLast(right);
            while (!maxq.isEmpty() && nums[right] < nums[maxq.peekLast()]) maxq.pollLast();
            maxq.addLast(right);

            while (!minq.isEmpty() && !maxq.isEmpty() &&
                    nums[maxq.peekFirst()] - nums[minq.peekFirst()] > limit){
                if (left == minq.getFirst()) minq.pollFirst();
                if (left == maxq.getFirst()) maxq.pollFirst();
                left++;
            }
            res = Math.max(res, left - right + 1);
        }

        return res;
    }
}
