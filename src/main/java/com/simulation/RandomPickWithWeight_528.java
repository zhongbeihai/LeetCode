package com.simulation;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight_528 {
    int[] prefix;
    int n;
    public RandomPickWithWeight_528(int[] w) {
        this.n = w.length;
        prefix = new int[this.n + 1];

        for (int i = 1; i <= this.n; i++){
            prefix[i] = prefix[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int total = prefix[this.n];  // 总权重
        Random random = new Random();
        int r = new Random().nextInt(total) + 1;

        int left = 0, right = this.n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (prefix[mid] >= r){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public static void main(String[] args) {
        RandomPickWithWeight_528 r = new RandomPickWithWeight_528(new int[]{1});
        r.pickIndex();
    }
}
