package com.hashtable;

import java.util.Arrays;
import java.util.Comparator;

public class TwoBestNonoverlappingEvent_2054 {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparing(i -> i[0]));

        int[] suffixBest = new int[n + 1];
        suffixBest[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixBest[i] = Math.max(suffixBest[i + 1], events[i][2]);
        }

        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {starts[i] = events[i][0];}

        int res = 0;
        for (int i = 0; i < n; i++) {
            int end = events[i][1], cur = events[i][2];
            int j = lowerBound(starts, end + 1);
            int bestSec = suffixBest[j];
            res = Math.max(res, cur + bestSec);
        }

        return res;
    }

    private int lowerBound(int[] arr, int target){
        int l = 0, r = arr.length; // [l, r)
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
