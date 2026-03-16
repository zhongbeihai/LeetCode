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

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(i -> -i.getValue()));
        pq.addAll(fre.entrySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements_347 topKFrequentElements_347 = new TopKFrequentElements_347();
        topKFrequentElements_347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
