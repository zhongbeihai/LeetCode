package com.greedy;

import java.util.Arrays;

public class MaximumNumberOfTasksYouCanAssign_2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length, res = 0;
        for (int i = 0; i < n; i++){
            if (workers[i] >= tasks[i]){
                res++;
            }else if (pills > 0 && workers[i] + strength >= tasks[i]){
                res++;
                pills--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfTasksYouCanAssign_2071 m = new MaximumNumberOfTasksYouCanAssign_2071();
        m.maxTaskAssign(new int[]{5,9,8,5,9}, new int[]{1,6,4,2,6}, 1, 5);
    }
}
