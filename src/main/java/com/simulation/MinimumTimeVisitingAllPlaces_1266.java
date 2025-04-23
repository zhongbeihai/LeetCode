package com.simulation;

public class MinimumTimeVisitingAllPlaces_1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];

        int count = 0;
        for(int i = 1; i < points.length; i++){
            int x2 = points[i][0], y2 = points[i][1];
            count += Math.max(Math.abs(x2-x1), Math.abs(y2-y1));

            x1 = x2;
            y1 = y2;
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumTimeVisitingAllPlaces_1266 m = new MinimumTimeVisitingAllPlaces_1266();
        m.minTimeToVisitAllPoints(new int[][]{{1,1},{3,4},{-1,0}});
    }
}
