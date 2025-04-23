package com.dynamic_programming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class JumpGameIV_1696 {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        PriorityQueue<Integer> deque = new PriorityQueue<>((o1, o2) -> dp[o2] - dp[o1]);
        deque.add(0);
        for (int i = 1; i < nums.length; i ++){
            while (!deque.isEmpty() && deque.peek() < i - k){
                deque.poll();
            }
            dp[i] = dp[deque.peek()] + nums[i];
            while (!deque.isEmpty() && dp[deque.peek()] < dp[i]){
                deque.poll();
            }
            deque.add(i);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        JumpGameIV_1696 j = new JumpGameIV_1696();
        j.maxResult(new int[]{100,-1,-100,-1,100}, 2);
    }
}
