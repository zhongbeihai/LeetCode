package com.dequeue_and_priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value,
 * and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far.
 * Answers within 10-5 of the actual answer will be accepted.
 */
public class MedianFinder_295 {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean isEven;

    public MedianFinder_295() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        isEven = true;
    }

    public void addNum(int num) {
        if(isEven){
            large.offer(num);
            small.offer(large.poll());
        }else {
            small.offer(num);
            large.offer(small.poll());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if(!isEven && !large.isEmpty()){
            return small.peek();
        }else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
