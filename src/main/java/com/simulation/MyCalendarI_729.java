package com.simulation;

import structure.Pair;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyCalendarI_729 {
    TreeMap<Integer, Integer> cal;
    public MyCalendarI_729() {
        cal = new TreeMap();
    }

    public boolean book(int startTime, int endTime) {
        cal.put(startTime, cal.getOrDefault(startTime, 0) + 1);
        cal.put(endTime, cal.getOrDefault(endTime, 0) - 1);

        int active = 0;
        for (int v: cal.values()){
            active += v;

            if (active > 1){
                // rollback;
                cal.put(startTime, cal.get(startTime) - 1);
                cal.put(endTime, cal.get(endTime) + 1);
                return false;
            }
        }
        return true;
    }
}
