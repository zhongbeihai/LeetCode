package com.two_pointers;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length, n = secondList.length;
        int i = 0, j = 0;

        List<int[]> list = new ArrayList<>();
        while (i < m && j < n){
            int[] first = firstList[i], second = secondList[j];
            int start = Math.max(first[0], second[0]);
            int end = Math.min(first[1], second[1]);
            if (start <= end) list.add(new int[]{start, end});

            // move the pointer
            if (first[1] <= second[1]) i++;
            else j++;
        }

        return list.toArray(new int[list.size()][]);
    }

}
