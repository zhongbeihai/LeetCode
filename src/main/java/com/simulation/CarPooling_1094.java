package com.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CarPooling_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        ArrayList<int[]> events = new ArrayList<>(); // {position, action( how many people get on car / get off car)
        for (int[] trip: trips){
            events.add(new int[]{trip[1], trip[0]});
            events.add(new int[]{trip[2], -trip[0]});
        }

        events.sort((i, j) ->{
            if (i[0] == j[0]) return i[1] - j[1];
            return i[0] - j[0];
        });

        int curPeople = 0;
        for (int[] e: events){
            curPeople += e[1];
            if (curPeople > capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling_1094 c = new CarPooling_1094();
        c.carPooling(new int[][]{{7,5,6},{6,7,8},{10,1,6}}, 16);
    }


}
