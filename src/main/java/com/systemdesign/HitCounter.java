package com.systemdesign;

import java.util.TreeMap;

public class HitCounter {
    private TreeMap<Integer, Integer> map;
    int acc = 0;
    public HitCounter() {
        map = new TreeMap<>();
        map.put(0, acc);
    }

    public void hit(int timestamp) {
        map.put(timestamp, acc + 1);
        acc++;
    }

    public int getHits(int timestamp) {
        int start = Math.max(timestamp - 300, 0);
        int startValue = map.floorEntry(start).getValue();
        int endValue = map.floorEntry(timestamp).getValue();
        return endValue - startValue;
    }
}
