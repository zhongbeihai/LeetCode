package com.dequeue_and_priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended_1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (i, j) -> {
            if(i[0] == j[0]) return i[1] - j[1];
            else return i[0] - j[0];
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int maxDay = 0;
        for (int[] e: events){
            maxDay = Math.max(maxDay, e[1]);
        }

        int day = 1, i = 0, res = 0, n = events.length;
        for (day = 1; day <= maxDay; day++){
            while (i < n && events[i][0] == day){
                minHeap.add(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day){
                minHeap.poll();
            }

            if (!minHeap.isEmpty()){
                res++;
                minHeap.poll();
            }
        }

        return res;
    }
}
