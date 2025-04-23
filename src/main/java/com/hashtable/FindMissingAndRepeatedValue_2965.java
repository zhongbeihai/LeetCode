package com.hashtable;

import java.util.HashSet;

public class FindMissingAndRepeatedValue_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= grid[0].length * grid[0].length; i++){
            set.add(i);
        }

        int[] res = new int[2];
        for (int[] row: grid){
            for (int i: row){
                if (!set.remove(i)) res[0] = i;
            }
        }
        res[1] = set.iterator().next();

        return res;
    }
}
