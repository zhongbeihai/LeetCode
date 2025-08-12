package com.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSmallestCommonElementInTheRows_1198 {
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length;
        Map<Integer, Integer> fre = new HashMap<>();
        for (int[] row: mat){
            for (int num: row){
                fre.put(num, fre.getOrDefault(num, 0) + 1);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: fre.entrySet()){
            if (entry.getValue() == n){
                ans = Math.min(ans, entry.getKey());
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int smallestCommonElement_binarySearchVersion(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int ans = -1;
        for (int col = 0; col < m; col++){
            boolean found = true;
            for (int row = 1; row < n && found; row++){
                found = Arrays.binarySearch(mat[row], mat[0][col]) >= 0;
            }

            if (found) return mat[0][col];
        }

        return ans;
    }
}
