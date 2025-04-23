package com.dynamic_programming;

import java.util.Arrays;

public class PaintHouses_256 {
    public int minCost(int[][] costs) {
        int n = costs.length, m = costs[0].length;
        int[] prev = new int[m];
        prev = costs[0];
        for (int i = 1; i < n; i++){
            int[] np = new int[m];
            for (int j = 0; j < m; j++){
                np[j] = minNotIncludeItself(prev, j) + costs[i][j];
            }
            prev = np;
        }

        int res = Integer.MAX_VALUE;
        for (int p: prev) res = Math.min(p, res);
        return res;
    }

    public int minNotIncludeItself(int[] arr, int itself){
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (i == itself) continue;;
            m = Math.min(m, arr[i]);
        }

        return m;
    }
}
