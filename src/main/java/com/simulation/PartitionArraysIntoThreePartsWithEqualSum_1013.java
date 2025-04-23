package com.simulation;

import java.util.Arrays;

public class PartitionArraysIntoThreePartsWithEqualSum_1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if(Arrays.stream(arr).allMatch(e -> e == 0)) return true;
        if(sum % 3 != 0) return false;
        sum /= 3;
        int part = 0, cnt = 0;
        for(int a: arr){
            part += a;
            if(part == sum){
                cnt++;
                part = 0;
            }
            if (cnt == 3) return true;
        }

        return false;
    }
}
