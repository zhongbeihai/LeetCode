package com.dequeue_and_priorityqueue;

import java.util.*;

/**
 * Given an integer array nums and an integer k,
 * return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        for (int num: nums){
            fre.put(num, fre.getOrDefault(num , 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1])); // {num, fre}
        for (Map.Entry<Integer, Integer> e: fre.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
            while (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0 ; i--) {
            res[i] = pq.poll()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements_347 topKFrequentElements_347 = new TopKFrequentElements_347();
        topKFrequentElements_347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
