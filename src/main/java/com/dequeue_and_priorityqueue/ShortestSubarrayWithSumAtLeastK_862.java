package com.dequeue_and_priorityqueue;

public class ShortestSubarrayWithSumAtLeastK_862  {
    public int shortestSubarray(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
        }

        int left = 0, right = 0, len = Integer.MAX_VALUE;
        while (left + 1< prefixSum.length){
            if(prefixSum[right] - prefixSum[left] < k){
                if(right + 1< prefixSum.length) right++;
                else left++;
            }else {
                left++;
            }
            if(prefixSum[right] - prefixSum[left] >= k){
                len = Math.min(len, right - left);
            }
        }

        return len == Integer.MAX_VALUE ? -1 : len;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK_862 s = new ShortestSubarrayWithSumAtLeastK_862();
        s.shortestSubarray(new int[]{-28,81,-20,28,-29}, 89);
    }
}
