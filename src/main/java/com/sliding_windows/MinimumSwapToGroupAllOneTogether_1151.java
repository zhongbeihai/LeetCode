package com.sliding_windows;

public class MinimumSwapToGroupAllOneTogether_1151 {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int o: data){
            totalOnes += o;
        }

        int curOnes = 0;
        for (int i = 0; i < totalOnes; i++){
            curOnes += data[i];
        }
        int res = totalOnes - curOnes;
        for (int i = totalOnes; i < data.length; i++){
            curOnes += data[i] - data[i - totalOnes];
            res = Math.min(res, totalOnes - curOnes);
        }

        return res;
    }
}
