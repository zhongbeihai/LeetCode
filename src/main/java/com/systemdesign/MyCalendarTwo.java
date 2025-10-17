package com.systemdesign;

import java.util.TreeMap;

public class MyCalendarTwo {
    private TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int active = 0;
        for (int v: map.values()){
            active += v;

            if (active > 2) {
                // rollback
                map.put(startTime, map.get(startTime) - 1);
                if (map.get(startTime) == 0) map.remove(startTime);
                map.put(endTime, map.get(endTime) + 1);
                if (map.get(endTime) == 0) map.remove(endTime);

                return false;
            }
        }

        return true;
    }
}
