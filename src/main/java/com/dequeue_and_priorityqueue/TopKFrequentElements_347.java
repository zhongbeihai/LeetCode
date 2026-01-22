package com.dequeue_and_priorityqueue;

import java.util.*;

/**
 * Given an integer array nums and an integer k,
 * return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements_347 {

    // use priority queue
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        for(int num: nums){
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[100000];
        for(Map.Entry<Integer, Integer> e: fre.entrySet()){
            if (buckets[e.getValue()] == null) buckets[e.getValue()] = new ArrayList<>();
            buckets[e.getValue()].add(e.getKey());
        }

        int[] res = new int[k];
        int j = 0;
        for (int i = buckets.length - 1; i >= 0; i--){
            if (j >= k) break;
            if (buckets[i] != null){
                List<Integer> list = buckets[i];
                int p = list.size() - 1;
                while (j < k && p >= 0) {
                    res[j++] = list.get(p--);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements_347 topKFrequentElements_347 = new TopKFrequentElements_347();
        topKFrequentElements_347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
