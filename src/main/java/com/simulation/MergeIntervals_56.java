package com.simulation;

import structure.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] last = list.get(list.size() - 1);
            int[] cur = intervals[i];
            if (cur[0] > last[1]) {
                list.add(intervals[i]);
            }else {
                list.remove(list.size() - 1);
                int start = Math.min(last[0], cur[0]);
                int end = Math.max(last[1], cur[1]);

                list.add(new int[]{start, end});
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        MergeIntervals_56 m = new MergeIntervals_56();
        m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
