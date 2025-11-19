package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        if (newInterval.length == 0) return intervals;

        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i++]);
        }
        int start = newInterval[0], end = newInterval[1];
        while (i < n && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        list.add(new int[]{start, end});
        while (i < n){
            list.add(intervals[i++]);
        }

        int[][] res = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

    }

    public static void main(String[] args) {
        InsertInterval_57 i = new InsertInterval_57();
        // i.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        // i.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        i.insert(new int[][]{{1,5}}, new int[]{6,8});
    }
}
