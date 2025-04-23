package com.dequeue_and_priorityqueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumSumWithDistinctSubarrayWithLengthK_2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int right = 0, left = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        long maxx = 0;
        long sum = 0;
        while (right < nums.length){
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];

            if(right - left < k) right++;
            else {
                right++;
                sum -= nums[left];
                count.put(nums[left], count.get(nums[left]) - 1);
                if(count.get(nums[left]) == 0) count.remove(nums[left]);
                left++;
            }

            if(count.size() == k && right - left == k)
                maxx = Math.max(maxx, sum);
        }

        return maxx;
    }

    public static void main(String[] args) {
        MaximumSumWithDistinctSubarrayWithLengthK_2461 m = new MaximumSumWithDistinctSubarrayWithLengthK_2461();
        m.maximumSubarraySum(new int[]{1,2,2}, 2);
    }
}
