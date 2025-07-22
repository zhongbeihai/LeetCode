package com.simulation;

public class SumOfUniqueElements_1748 {
    public int sumOfUnique(int[] nums) {
        int[] fre = new int[101];
        for (int num: nums){
            fre[num]++;
        }

        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (fre[i] == 1) sum += i;
        }

        return sum;
    }
}
