package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        if (newInterval.length == 0) return intervals;

        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);
        int start = newInterval[0], end = newInterval[1];
        while (i < n && (newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0])){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        res.add(new int[]{start, end});

        while (i < intervals.length){
            res.add(intervals[i++]);
        }

        int[][] r = new int[res.size()][];
        for (int j = 0; j < res.size(); j++) {
            r[j] = res.get(j);
        }
        return r;
    }

    public static void main(String[] args) {
        InsertInterval_57 i = new InsertInterval_57();
        i.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        // i.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        i.insert(new int[][]{{1,5}}, new int[]{6,8});
    }
}
