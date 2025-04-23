package com.dequeue_and_priorityqueue;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int num : nums) {
            queue.add(num);
        }

        int r = 0;
        for(int i = 0; i < k; i++){
            r = queue.poll();
        }

        return r;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray_215 k = new KthLargestElementInAnArray_215();
        k.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
