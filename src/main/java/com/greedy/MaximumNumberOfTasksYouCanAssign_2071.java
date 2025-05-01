package com.greedy;

import sun.security.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumNumberOfTasksYouCanAssign_2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0, high = Math.min(tasks.length, workers.length);

        while (low < high){
            int mid = (low + high + 1) / 2;
            if (canAssign(tasks, workers, mid, pills, strength)){
                low = mid;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }

    public boolean canAssign(int[] tasks, int[] works, int mid, int pills, int strength){
        int w = works.length - 1;

        Deque<Integer> boostedWorkers = new ArrayDeque<>();

        for (int i = mid - 1; i >= 0; i--){
            if (!boostedWorkers.isEmpty() && boostedWorkers.peekFirst() >= tasks[i]){
                boostedWorkers.pollFirst();
            } else if (w >= 0 && works[w] >= tasks[i]) {
                w--;
            }else {
                while (w >= 0 && works[w] + strength >= tasks[i]){
                    boostedWorkers.addLast(works[w--]);
                }
                if (boostedWorkers.isEmpty() || pills == 0) return false;
                boostedWorkers.pollLast();
                pills--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MaximumNumberOfTasksYouCanAssign_2071 m = new MaximumNumberOfTasksYouCanAssign_2071();
        boolean f = m.canAssign(new int[]{5,9,8,5,9}, new int[]{1,6,4,2,6}, 1,1, 5);
            m.maxTaskAssign(new int[]{5,9,8,5,9}, new int[]{1,6,4,2,6}, 1, 5);
    }
}
