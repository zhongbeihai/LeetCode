package com.simulation;

import java.util.*;

public class CountThePositionOnStreetWithRequiredBrightness_2237 {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        List<int[]> events = new ArrayList<>();
        for (int[] p: lights){
            events.add(new int[]{Math.max(0, p[0] - p[1]), 1});
            events.add(new int[]{Math.min(n, p[0] + p[1] + 1), -1});
        }
        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res = 0, cur = 0, i = 0;
        for (int[] event: events){
            while (i < event[0]){
                if (requirement[i] <= cur) res++;
                i++;
            }
            cur += event[1];
        }

        while (i < n){
            if (requirement[i] <= cur) res++;
            i++;
        }

        return res;

    }

    public static void main(String[] args) {
        CountThePositionOnStreetWithRequiredBrightness_2237 c= new CountThePositionOnStreetWithRequiredBrightness_2237();
        // c.meetRequirement(5, new int[][]{{0,1},{2,1},{3,2}}, new int[]{0,2,1,4,1});
        c.meetRequirement(2, new int[][]{{1,2},{1,1},{1,1}}, new int[]{5,3});
    }
}
