package com.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumOperationsToMakeAUniValueGrid_2033 {
    public int minOperations(int[][] grid, int x) {
        List<Integer> arr = new ArrayList<>();

        int c = 0;
        for (int[] row : grid) {
            for (int val : row) {
                arr.add(val);
            }
        }
        Collections.sort(arr);
        for (int v: arr){
            if (Math.abs(v - arr.get(0)) % x != 0) return -1;
        }

        int median = arr.get(arr.size() / 2);

        int operations = 0;

        for (int val : arr) {
            operations += Math.abs(val - median) / x;
        }

        return operations;
    }
}// 1 1 2 3 5