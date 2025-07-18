package com.dynamic_programming;

import java.util.*;

public class MinimumDifferenceInSumAfterRemovalOfElement_2163 {
    public long minimumDifference(int[] nums) {
        int n = nums.length, m = nums.length / 3;
        long[] left = new long[n], right = new long[n];
        Arrays.fill(left, Long.MAX_VALUE);
        Arrays.fill(right, Long.MIN_VALUE);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < n; i++){
            maxHeap.offer(nums[i]);
            sum += nums[i];
            if (maxHeap.size() > m){
                sum -= maxHeap.poll();
            }
            if (maxHeap.size() == m) left[i] = sum;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);
            sum += nums[i];
            if (minHeap.size() > m){
                sum -= minHeap.poll();
            }
            if (minHeap.size() == m) right[i] = sum;
        }

        long ans = Long.MAX_VALUE;
        for (int i = m - 1; i < 2 * m; ++i) {   // 分割点范围 [n‑1, 2n‑1]
            ans = Math.min(ans, left[i] - right[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumDifferenceInSumAfterRemovalOfElement_2163 m = new MinimumDifferenceInSumAfterRemovalOfElement_2163();
        m.minimumDifference(new int[]{7,9,5,8,1,3});
    }
}
