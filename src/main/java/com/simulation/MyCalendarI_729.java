package com.simulation;

import javafx.util.Pair;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyCalendarI_729 {
    TreeMap<Integer, Integer> cal;
    public MyCalendarI_729() {
        cal = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer floorKey = cal.floorKey(start);
        Integer ceilingKey = cal.ceilingKey(start);
        if(floorKey != null && cal.get(floorKey) > start) {
            return false;
        }
        if(ceilingKey != null && cal.get(ceilingKey) <= end) {
            return false;
        }
        cal.put(start, end);
        return true;
    }
}
