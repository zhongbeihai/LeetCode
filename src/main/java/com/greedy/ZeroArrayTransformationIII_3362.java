package com.greedy;

import java.util.*;

public class ZeroArrayTransformationIII_3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int queriesLength = queries.length;

        HashMap<Integer, List<Integer>> queriesStartAt = new HashMap<>();
        for (int[] query: queries){
            queriesStartAt.computeIfAbsent(query[0], k -> new ArrayList<>()).add(query[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long[] diff = new long[n + 1];
        long queriesSelectedCount = 0;
        long currentCoverage = 0;

        for (int i = 0; i < n; i++){
            if (queriesStartAt.containsKey(i)){
                pq.addAll(queriesStartAt.get(i));
            }

            // remove unavailable queries
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }

            currentCoverage += diff[i];
            long needed = (long)nums[i] - currentCoverage;

            if (needed > 0){
                for (long k = 0; k < needed; k++){
                    while(!pq.isEmpty() && pq.peek() < i){
                        pq.poll();
                    }

                    if (pq.isEmpty()) return -1;

                    int r_chosen = pq.poll();
                    queriesSelectedCount++;
                    currentCoverage++;

                    if (r_chosen < n){
                        diff[r_chosen + 1]--;
                    }
                }
            }
        }

        return (int) (queriesLength - queriesSelectedCount);
    }
}
