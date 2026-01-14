package com.prefixsum;

import structure.Pair;

public class CountTheHiddenSequences_2145 {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long upperBound = 0, lowerBound = 0;

        long sum = 0;
        for (int diff: differences){
            sum += diff;
            lowerBound = Math.min(lowerBound, sum);
            upperBound = Math.max(upperBound, sum);
        }

        long minStart = lower - lowerBound;
        long maxStart = upper - upperBound;

        return (int) Math.max(0, maxStart - minStart + 1);
    }



    public static void main(String[] args) {
        CountTheHiddenSequences_2145 c= new CountTheHiddenSequences_2145();
        c.numberOfArrays(new int[]{1,-3,4},1, 6);
    }
}
