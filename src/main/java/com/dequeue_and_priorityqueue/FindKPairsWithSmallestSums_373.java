package com.dequeue_and_priorityqueue;

import java.util.*;

public class FindKPairsWithSmallestSums_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
        int[] n = new int[]{nums1[0] + nums2[0], 0, 0};
        pq.add(n);

        List<List<Integer>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add("0#0");

        while (!pq.isEmpty() && res.size() < k) {
            int[] cur = pq.poll();
            List<Integer> tem = Arrays.asList(nums1[cur[1]], nums2[cur[2]]);
            res.add(new ArrayList<>(tem));

            if (cur[1] + 1 < nums1.length) {
                int i = cur[1] + 1, j = cur[2];
                String key = i + "#" + j;
                if (visited.add(key)) {
                    int[] n1 = new int[]{nums1[i] + nums2[j], i, j};
                    pq.add(n1);
                }
            }

            if (cur[2] + 1 < nums2.length) {
                int i = cur[1], j = cur[2] + 1;
                String key = i + "#" + j;
                if (visited.add(key)) {
                    int[] n2 = new int[]{nums1[i] + nums2[j], i, j};
                    pq.add(n2);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums_373 f = new FindKPairsWithSmallestSums_373();
        f.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
    }
}
