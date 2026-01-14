package com.simulation;

import structure.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
       List<int[]> list = new ArrayList<>();

       for (int[] interval: intervals){
           if (list.isEmpty()) list.add(interval);
           else {
               if (interval[0] > list.get(list.size() - 1)[1]) list.add(interval);
               if (interval[0] <= list.get(list.size() - 1)[1]) list.get(list.size() - 1)[1] = Math.max(interval[1], list.get(list.size() - 1)[1]);
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
