package com.dequeue_and_priorityqueue;

import java.util.PriorityQueue;

public class SlidingWindowMedian_480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // add number
            if(minHeap.isEmpty() || nums[i] >= minHeap.peek()){
                minHeap.add(nums[i]);
            }else {
                maxHeap.add(nums[i]);
            }
            //balance
            if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }
            if(i >= k){
                // delete number
                if(nums[i - k] <= maxHeap.peek()){
                    maxHeap.remove(nums[i-k]);
                }else{
                    minHeap.remove(nums[i-k]);
                }
                //balance
                if(maxHeap.size() > minHeap.size()){
                    minHeap.add(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size() + 1) {
                    maxHeap.add(minHeap.poll());
                }
            }

            if(i >= k - 1){
                // get median
                if(minHeap.size() == maxHeap.size()){
                    res[i - k + 1] = (minHeap.peek() + maxHeap.peek()) / 2.0;
                }else {
                    res[i - k + 1] = minHeap.peek();
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        SlidingWindowMedian_480 s = new SlidingWindowMedian_480();
        s.medianSlidingWindow(new int[]{2147483647,2147483647},2);
    }
}
