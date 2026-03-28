package com.dequeue_and_priorityqueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheKSumOfArray_2386 {
    // we take all the positive number -> maximumSum
    // we transfer the nums[i] -> loss -> each number is a loss to the maximum sum
    // search the loss
    //      not take a positive/ take negative number
    // we can use a priorityQueue to search
    // we can use an int[]{loss, idx}
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long maximumSum = 0L;
        for(int i = 0; i < n; i++){
            if (nums[i] > 0) maximumSum += nums[i];
            else {
                nums[i] = -nums[i]; // transfer the nums into losses
            }
        }
        if (k == 1) return maximumSum;

        Arrays.sort(nums);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i[0])); // {curLoss, idx}
        pq.add(new long[]{nums[0], 0});

        // we want find k -1 smallest loss
        long loss = 0L;
        for (int i = 1; i < k; i++) {
            long[] cur = pq.poll();
            loss = cur[0];
            int curIdx = Math.toIntExact(cur[1]);

            if(curIdx + 1 < n){
                // keep adding nums[i + 1] as loss
                pq.add(new long[]{loss + nums[curIdx + 1], curIdx + 1});

                // remove loss nums[i], then we add nums[i + 1]
                pq.add(new long[]{loss - nums[curIdx] + nums[curIdx + 1], curIdx + 1});
            }
        }

        return maximumSum - loss;
    }

    public static void main(String[] args) {
        FindTheKSumOfArray_2386 f = new FindTheKSumOfArray_2386();
        f.kSum(new int[]{2,4,-2}, 5);
    }
}
