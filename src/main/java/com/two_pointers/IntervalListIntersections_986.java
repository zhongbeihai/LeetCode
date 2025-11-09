package com.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[][]{};

        int fp = 0, sp = 0;
        List<int[]> res = new ArrayList<>();

        while (fp < firstList.length && sp < secondList.length){
            int[] f = firstList[fp], s = secondList[sp];
            int start = Math.max(f[0], s[0]), end = Math.min(f[1], s[1]);
            if (start <= end) res.add(new int[]{start, end});
            if (f[1] < s[1]) fp++;
            else sp++;

        }

        int[][] r = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) r[i] = res.get(i);
        return r;
    }

}
