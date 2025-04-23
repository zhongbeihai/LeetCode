package com.simulation;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumOperationsToExceedThresholdValuesII_3066 {
    // There is an integer array "num", and an integer k,
    public int minOperations(int[] nums, int k) {
        if (nums.length < 2) return 0;
        // Priority Queue
        PriorityQueue<Long> pq = new PriorityQueue<>(Arrays.stream(nums).
                mapToLong(i -> (long) i).boxed().collect(Collectors.toList()));

        int res = 0;
        // stop condition
        while (pq.size() >= 2 && pq.peek() < k){
            long p1 = pq.poll(), p2 = pq.poll();
            long ne = Math.min(p1, p2) * 2 + Math.max(p1, p2);
            pq.add(ne);
            res++;
        }

        return  res;
    }
}
