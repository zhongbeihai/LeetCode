package com.simulation;

import java.util.*;

public class BrightestPositionOnTheStreet_2021 {
    public int brightestPosition(int[][] lights) {
        List<int[]> events = new ArrayList<>();  // {position, action(+1, -1)}
        for (int[] light: lights){
            events.add(new int[]{light[0] - light[1], +1});
            events.add(new int[]{light[0] + light[1] + 1, -1});
        }

        events.sort((i, j) -> {
            if (i[0] == j[0]) return i[1] - j[1];
            return i[0] - j[0];
        });
        int max = 0, cur = 0, position = 0;
        for (int[] e: events){
            cur += e[1];
            if (cur > max){
                max = cur;
                position = e[0];
            }
        }

        return position;
    }

    public static void main(String[] args) {
        BrightestPositionOnTheStreet_2021 b = new BrightestPositionOnTheStreet_2021();
        b.brightestPosition(new int[][]{{1,1},{2,4},{-1,0},{-3,5},{1,2}});
    }
}
