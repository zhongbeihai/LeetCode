package com.systemdesign;

import kotlin.UByte;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> inner = map.get(key);
        if (inner == null) return "";

        Map.Entry<Integer, String> e =  inner.floorEntry(timestamp);
        return e == null ? "" : e.getValue();
    }
}
