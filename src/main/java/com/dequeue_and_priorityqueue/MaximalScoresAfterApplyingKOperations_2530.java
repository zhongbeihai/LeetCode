package com.dequeue_and_priorityqueue;

import java.util.*;
import java.util.stream.Collectors;

public class MaximalScoresAfterApplyingKOperations_2530 {
    public long maxKelements(int[] nums, int k) {
        if(nums.length == 0) return 0L;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }
        long sum = 0L;
        for(int i = 0; i < k; i++){
            int a = queue.poll();
            sum += a;
            queue.add((int) Math.ceil(a / 3.0));
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximalScoresAfterApplyingKOperations_2530 m = new MaximalScoresAfterApplyingKOperations_2530();
        m.maxKelements(new int[]{1,10,3,3,3}, 3);
    }
}
