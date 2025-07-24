package com.simulation;

import com.sun.scenario.effect.Merge;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> deque= new ArrayList<>();
        deque.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++){
            int[] last = deque.get(deque.size() - 1);

            if (intervals[i][0] > last[1]){
                deque.add(intervals[i]);
            }else {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }


        return deque.toArray(new int[deque.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals_56 m = new MergeIntervals_56();
        m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
