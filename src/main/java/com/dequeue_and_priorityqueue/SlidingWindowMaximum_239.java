package com.dequeue_and_priorityqueue;


import java.util.ArrayDeque;

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
        // maintain a monotonically increasing queue, so the head elem is always the biggest elem
        // head    -> queue moving direction ->
        //   |
        //   3   ->  7  -> 9
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int ind = 0;
        // head element must be within [i - k + 1, i]
        for(int i = 0; i < nums.length; i++){
            // while the window is sliding , so we must keep the head element within the range
            while(!dq.isEmpty() && dq.peek() < i - k + 1){
                dq.pollFirst();
            }
            //  Since the queue is monotonically increasing, so the new one must be bigger
            // than the last one in the queue or the new one would be abandoned
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);

            if(i >= k - 1){
                res[ind++] = nums[dq.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum_239 s = new SlidingWindowMaximum_239();
        s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
