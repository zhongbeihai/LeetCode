package com.simulation;

public class MaximumMatrixSum_1075 {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minValue = Integer.MAX_VALUE;
        int negCount = 0;

        for(int[] row: matrix){
            for(int v: row){
                if(v < 0) negCount++;
                sum += Math.abs(v);
                minValue = Math.min(minValue, Math.abs(v));
            }
        }

        if(negCount % 2 == 0) return sum;

        return sum - minValue - minValue;
    }
}
