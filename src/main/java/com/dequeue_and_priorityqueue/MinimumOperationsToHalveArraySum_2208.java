package com.dequeue_and_priorityqueue;

import java.io.DataOutput;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum_2208 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> 0-i));
        double sum = 0;
        for (int num: nums){
            pq.add((double) num);
            sum += num;
        }

        double curSum = sum;
        int cnt = 0;
        while (!pq.isEmpty() && curSum * 2 > sum){
            double p = pq.poll();
            curSum -= p / 2.0;
            pq.add(p / 2.0);
            cnt++;
        }

        return cnt;
    }
}
