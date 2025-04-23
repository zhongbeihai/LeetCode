package com.simulation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CarPooling_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        // starts[i] = [startLocation, numPassengers]
        // ends[i]   = [endLocation,   numPassengers]
        int[][] starts = new int[n][2];
        int[][] ends   = new int[n][2];

        for (int i = 0; i < n; i++){
            int num = trips[i][0];
            int s   = trips[i][1];
            int e   = trips[i][2];
            starts[i][0] = s;
            starts[i][1] = num;
            ends[i][0]   = e;
            ends[i][1]   = num;
        }

        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(ends,   (a, b) -> Integer.compare(a[0], b[0]));

        int sp = 0, ep = 0;

        while (sp < n) {

            while (ep < n && starts[sp][0] >= ends[ep][0]) {
                capacity += ends[ep][1];
                ep++;
            }

            capacity -= starts[sp][1];
            if (capacity < 0) {
                return false;
            }
            sp++;
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling_1094 c = new CarPooling_1094();
        c.carPooling(new int[][]{{7,5,6},{6,7,8},{10,1,6}}, 16);
    }


}
