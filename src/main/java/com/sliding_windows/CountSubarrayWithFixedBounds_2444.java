package com.sliding_windows;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class CountSubarrayWithFixedBounds_2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int res = 0, n = nums.length;
        int left = 0;
        Deque<Integer> minQue = new ArrayDeque<>();
        Deque<Integer> maxQue = new ArrayDeque<>();

        for(int right = 0; right < n; right++){
            if (nums[right] < minK || nums[right] > maxK){
                minQue.clear();
                maxQue.clear();
                left = right + 1;
                continue;
            }

            while (!minQue.isEmpty() && nums[minQue.peekLast()] >= nums[right]) minQue.pollLast();
            minQue.addLast(right);
            while (!maxQue.isEmpty() && nums[maxQue.peekLast()] <= nums[right] ) maxQue.pollLast();
            maxQue.addLast(right);

            if (nums[minQue.peekFirst()] == minK && nums[maxQue.peekFirst()] == maxK) {
                int start = Math.min(minQue.peekFirst(), maxQue.peekFirst());
                res += (start - left + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CountSubarrayWithFixedBounds_2444 c = new CountSubarrayWithFixedBounds_2444();
        c.countSubarrays(new int[]{3,1,5,2,7,5}, 1, 5);
    }
}
