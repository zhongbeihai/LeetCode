package com.prefixsum;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class MakeArrayZeroBySubtractingEqualAmounts_2357 {
    public int minimumOperations(int[] nums) {
        TreeSet<Integer> pq = new TreeSet<>();
        int max = 0, preSum = 0;
        for (int num: nums){
            if (num != 0) pq.add(num);
            max = Math.max(max, num);
        }

        int res = 0;
        while (!pq.isEmpty() && preSum < max){
            int l = pq.pollFirst() - preSum;
            preSum += l;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        MakeArrayZeroBySubtractingEqualAmounts_2357 m = new MakeArrayZeroBySubtractingEqualAmounts_2357();
        m.minimumOperations(new int[]{1,1,1,2,2,2,3,3});
    }
}
