package com.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int count = 0;
        int last = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[last][1]){
                if(intervals[i][1] < intervals[last][1]){
                    last = i;
                }
                count++;
            }else {
                last = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonoverlappingIntervals_435 n = new NonoverlappingIntervals_435();
        n.eraseOverlapIntervals(new int[][]{{0,2},{1,3},{2,4},{3,5},{4,6}});
    }
}
