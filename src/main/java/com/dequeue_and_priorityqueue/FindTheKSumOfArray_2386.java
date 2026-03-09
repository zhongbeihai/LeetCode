package com.dequeue_and_priorityqueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheKSumOfArray_2386 {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long all = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) all += nums[i];
            else nums[i] = Math.abs(nums[i]);
        }

        if(k == 1) return all;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i[0])); // {cur loss, index}
        Arrays.sort(nums);
        pq.add(new long[]{(long)nums[0], 0L});

        long loss = 0L;
        for (int i = 1; i < k; i++) {
            long[] cur = pq.poll();
            loss = cur[0];
            long lastIdx = cur[1];
            if (lastIdx + 1 < n){
                // 1. add next loss
                long nextLoss = nums[Math.toIntExact(lastIdx + 1)];
                pq.add(new long[]{loss + nextLoss, lastIdx + 1});

                // 2. remove last loss and add next loss;
                long lastLoss = nums[Math.toIntExact(lastIdx)];
                pq.add(new long[]{loss - lastLoss + nextLoss, lastIdx + 1});
            }
        }

        return all - loss;
    }
}
