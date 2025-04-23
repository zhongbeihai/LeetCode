package com.simulation;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap(){
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }else {
            map.get(key).put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> t = map.get(key);
        if (t != null){
            if (t.containsKey(timestamp)){
                return t.get(timestamp);
            } else if (timestamp < t.firstKey()){
                return "";
            }else {
                return t.lowerEntry(timestamp).getValue();
            }
        }else {
            return "";
        }

    }
}
