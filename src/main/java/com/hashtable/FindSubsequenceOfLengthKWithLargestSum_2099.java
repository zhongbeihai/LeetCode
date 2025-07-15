package com.hashtable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithLargestSum_2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) pq.poll();
        }

        int[][] indices = pq.toArray(new int[0][0]);
        Arrays.sort(indices, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices[i][1]];
        }
        return result;
    }

    public static void main(String[] args) {
        FindSubsequenceOfLengthKWithLargestSum_2099 f = new FindSubsequenceOfLengthKWithLargestSum_2099();
        f.maxSubsequence(new int[]{5, 1, 4, 3, 2, 4}, 3);
    }
}
