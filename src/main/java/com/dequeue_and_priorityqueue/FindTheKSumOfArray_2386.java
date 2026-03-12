package com.dequeue_and_priorityqueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheKSumOfArray_2386 {
    public long kSum(int[] nums, int k) {
        long maximumSum = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) maximumSum += nums[i];
            else nums[i] = - nums[i];
        }

        Arrays.sort(nums);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i[0])); // {accLoss, index};
        pq.add(new long[]{0L, 0L});

        for (int i = 1; i < k; i++) {
            long[] cur = pq.poll();
            long curLoss = cur[0], curIndex = cur[1];

            if (curIndex + 1 < nums.length){
                // 1. add next loss
                long nextLoss = nums[Math.toIntExact(curIndex + 1)];
                pq.add(new long[]{curLoss + nextLoss, curIndex + 1});

                // 2. remove last loss and add net loss
                long lastLoss = nums[Math.toIntExact(curIndex)];
                pq.add(new long[]{curLoss - lastLoss + nextLoss, curIndex + 1});
            }
        }

        return maximumSum - pq.poll()[0];
    }

    public static void main(String[] args) {
        FindTheKSumOfArray_2386 f = new FindTheKSumOfArray_2386();
        f.kSum(new int[]{2,4,-2}, 5);
    }
}
