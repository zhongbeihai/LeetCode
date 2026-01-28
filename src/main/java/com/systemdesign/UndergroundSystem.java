package com.systemdesign;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer, String> checkinStation = new HashMap<>();
    Map<Integer, Integer> checkinTime = new HashMap<>();
    Map<String, Double> totalTime = new HashMap<>(); // < "startStation" + "+" + "endStation", total time>
    Map<String, Integer> passengerCnt = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkinTime.put(id, t);
        checkinStation.put(id, stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        int usedTime = t - checkinTime.get(id);
        String key = checkinStation.get(id) + "+" + stationName;

        totalTime.put(key, totalTime.getOrDefault(key, 0.0) + usedTime);
        passengerCnt.put(key, passengerCnt.getOrDefault(key, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "+" + endStation;

        return totalTime.get(key) / passengerCnt.get(key);
    }
}
