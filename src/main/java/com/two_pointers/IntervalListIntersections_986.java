package com.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length ==0 || secondList.length == 0) return new int[0][0];

        List<int[]> res = new ArrayList<>();
        int fp = 0, sp = 0;
        while (fp < firstList.length && sp < secondList.length){
            int[] f = firstList[fp], s = secondList[sp];
            if (f[1] >= s[0] && f[0] <= s[1]) res.add(new int[]{Math.max(f[0], s[0]), Math.min(f[1], s[1])});

            if (f[1] <= s[1]) fp++;
            else sp++;
        }

        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }

        return r;
    }

}
