package com.dequeue_and_priorityqueue;

import java.util.*;

public class TotalCostToHireKCandidate_2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        Deque<Integer> wholeCandidates = new ArrayDeque<>();
        for (int cost : costs) wholeCandidates.add(cost);

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < candidates && !wholeCandidates.isEmpty(); i++) {
            left.add(wholeCandidates.pollFirst());
        }
        for (int i = 0; i < candidates && !wholeCandidates.isEmpty(); i++) {
            right.add(wholeCandidates.pollLast());
        }

        long totalCosts = 0;
        for (int i = 0; i < k; i++){
            if (!left.isEmpty() && (right.isEmpty() || left.peek() <= right.peek())){
                totalCosts += left.poll();
                if (!wholeCandidates.isEmpty()) left.add(wholeCandidates.pollFirst());
            }else {
                totalCosts += right.poll();
                if (!wholeCandidates.isEmpty()) right.add(wholeCandidates.pollLast());
            }
        }

        return totalCosts;
    }

    public static void main(String[] args) {
        TotalCostToHireKCandidate_2462 t = new TotalCostToHireKCandidate_2462();
        t.totalCost(new int[]{57,33,26,76,14,67,24,90,72,37,30}, 11,2);
    }
}
