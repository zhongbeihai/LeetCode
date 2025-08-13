package com.simulation;

import java.util.*;

public class BrightestPositionOnTheStreet_2021 {
    public int brightestPosition(int[][] lights) {
        List<int[]> events = new ArrayList<>();
        for (int[] light: lights){
            events.add(new int[]{light[0] - light[1], 1});
            events.add(new int[]{light[0] + light[1] + 1, -1});
        }

        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int res = -1;

        for (int[] ev: events){
            cur += ev[1];

            if (cur > max){
                max = cur;
                res = ev[0];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BrightestPositionOnTheStreet_2021 b = new BrightestPositionOnTheStreet_2021();
        b.brightestPosition(new int[][]{{3,4},{2,10},{-4,8},{5,7},{3,6},{3,6}});
    }
}
