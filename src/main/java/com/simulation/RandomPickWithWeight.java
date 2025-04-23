package com.simulation;

import java.util.*;

public class RandomPickWithWeight {
    private int[] prefixSum;
    private int totalSum;
    private Random random;
    public RandomPickWithWeight(int[] w) {
        this.prefixSum = new int[w.length];
        this.totalSum = 0;
        this.random = new Random();

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int random = r.nextInt(totalSum) + 1;
        int left = 0, right = prefixSum.length - 1;
        while (left <= right){
            int mid = left + (right - left) /2 ;
            if (prefixSum[mid] < random){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        RandomPickWithWeight r = new RandomPickWithWeight(new int[1]);
    }
}
