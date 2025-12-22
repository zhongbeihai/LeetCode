package com.simulation;

import structure.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++){
            int[] cur = intervals[i];
            if (cur[0] <= prev[1]){
                prev[1] = Math.max(prev[1], cur[1]);
            }else {
                list.add(prev);
                prev = cur;
            }
        }
        list.add(prev);

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals_56 m = new MergeIntervals_56();
        m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
