package com.dequeue_and_priorityqueue;

import java.util.*;

/**
 * Given an integer array nums and an integer k,
 * return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements_347 {

    // use priority queue
    public int[] topKFrequent(int[] nums, int k) {

        class myComparator implements  Comparator<Map.Entry<Integer, Integer>>{

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }



        PriorityQueue<Map.Entry<Integer, Integer>> queue= new PriorityQueue<>(new myComparator());

        for(Map.Entry<Integer, Integer> e : count.entrySet()){
            queue.add(e);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = queue.poll().getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements_347 topKFrequentElements_347 = new TopKFrequentElements_347();
        topKFrequentElements_347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
