package com.simulation;

import java.util.*;

public class TheKWeakestRowsInAMatrix_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < mat.length; i++){
            int count = 0;
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 1) count++;
            }
            l.add(new int[]{i, count});
        }

        // sort
        for (int i = 1; i < l.size(); i++){
            int[] key = l.get(i);
            int j = i - 1;
            while (j >= 0 && l.get(j)[1] > key[1]){
                l.set(j + 1, l.get(j));
                j--;
            }
            l.set(j + 1, key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = l.get(i)[0];
        }

        return res;
    }
}
