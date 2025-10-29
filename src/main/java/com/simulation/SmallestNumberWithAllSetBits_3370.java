package com.simulation;

public class SmallestNumberWithAllSetBits_3370 {
    public int smallestNumber(int n) {
        int x = 0b1;
        while (x < n){
            x = (x << 1) | 1;
        }

        return x;
    }
}
