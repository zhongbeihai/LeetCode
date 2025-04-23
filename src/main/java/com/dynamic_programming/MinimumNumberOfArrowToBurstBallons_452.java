package com.dynamic_programming;

import java.util.Arrays;

public class MinimumNumberOfArrowToBurstBallons_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, ((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])));

        int count = 1, l = points[0][0], r = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > r ) {
                count++;
                r = points[i][1];
            }
            r = Math.min(r, points[i][1]);
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowToBurstBallons_452 m = new MinimumNumberOfArrowToBurstBallons_452();
        //m.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});
        m.findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}});
    }
}
