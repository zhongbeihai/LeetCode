package com.systemdesign;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer, Integer> checkinTime = new HashMap<>(); // < id, checkinTime>
    Map<Integer, String> checkinStation = new HashMap<>(); // <id, "checkin Station">
    Map<String, int[]> timeMap = new HashMap<>(); // <"startStation+endStation", (totalTime, number of customer)>
    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkinTime.put(id, t);
        checkinStation.put(id, stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        int t1 = checkinTime.get(id);
        if (t1 > t) return;

        int timeUsed = t - t1;
        String s1 = checkinStation.get(id);

        String key = s1 + "+" + stationName;
        timeMap.computeIfAbsent(key, k -> new int[]{0, 0});
        int[] tem = timeMap.get(key);
        tem[0] += timeUsed;
        tem[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "+" + endStation;
        int[] tem = timeMap.get(key);
        if (tem[0] == 0) return 0;

        return tem[0] / (double) tem[1];
    }
}
