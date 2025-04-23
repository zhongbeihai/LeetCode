package com.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumCostForCuttingCakeI_3218 {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int h = horizontalCut.length - 1, v = verticalCut.length - 1;
        int cost = 0;
        if(h < 0){
            cost = Arrays.stream(verticalCut).sum();
            return cost;
        }
        if(v < 0){
            cost = Arrays.stream(horizontalCut).sum();
            return cost;
        }
        int opeV = 1;
        int opeH = 1;
        while (v >= 0 || h >= 0){
            if(verticalCut[v] > horizontalCut[h]){
                cost += verticalCut[v];
                v--;
                opeV++;
                doubleArray(horizontalCut, opeV);
            } else if (verticalCut[v] == horizontalCut[h]) {
                if(v > h){
                    cost += verticalCut[v];
                    v--;
                    opeV++;
                    doubleArray(horizontalCut, opeV);
                }else {
                    cost += horizontalCut[h];
                    h--;
                    opeH++;
                    doubleArray(verticalCut, opeH);
                }
            } else {
                cost += horizontalCut[h];
                h--;
                opeH++;
                doubleArray(verticalCut, opeH);
            }
            if(h < 0){
                while (v >= 0){
                    cost += verticalCut[v];
                    v--;
                }
            }
            if(v < 0){
                while (h >= 0){
                    cost += horizontalCut[h];
                    h--;
                }
            }
        }

        return cost;
    }

    public void doubleArray(int[] arr, int n){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] / (n - 1) * n;
        }
    }

    public static void main(String[] args) {
        MinimumCostForCuttingCakeI_3218 m = new MinimumCostForCuttingCakeI_3218();
        m.minimumCost(6, 3, new int[]{2,3,2,3,1}, new int[]{1,2});
    }
}
