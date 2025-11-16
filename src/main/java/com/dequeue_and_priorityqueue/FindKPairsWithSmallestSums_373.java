package com.dequeue_and_priorityqueue;

import java.util.*;

public class FindKPairsWithSmallestSums_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0])); // int[sum, x, y]
        for (int i = 0; i < Math.min(k, nums1.length); i++){
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        List<List<Integer>> res = new ArrayList<>(k);
        while (k > 0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[1], y = cur[2], n1 = nums1[x], n2 = nums2[y];
            List<Integer> pair = new ArrayList<>(2);
            pair.add(n1);
            pair.add(n2);
            res.add(pair);
            if (y + 1 < nums2.length) pq.add(new int[]{nums1[x] + nums2[y + 1], x, y + 1});
            k--;
        }

        return res;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums_373 f = new FindKPairsWithSmallestSums_373();
        f.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
    }
}
