package com.simulation;

import structure.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

       List<int[]> list = new ArrayList<>();
       list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1), cur = intervals[i];

            if (cur[0] > last[1]) list.add(cur);
            else {
                last[1] = Math.max(last[1], cur[1]);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        MergeIntervals_56 m = new MergeIntervals_56();
        m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
