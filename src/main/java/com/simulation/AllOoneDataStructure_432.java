package com.simulation;

import java.util.Comparator;
import java.util.TreeMap;

public class AllOoneDataStructure_432 {
    private TreeMap<String, Integer> map;
    public AllOoneDataStructure_432() {
        map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String k1, String k2) {
                int comp = map.get(k1).compareTo(map.get(k2)); // 按值排序
                if (comp == 0) {
                    return k1.compareTo(k2); // 如果值相等，按键排序
                }
                return comp;
            }
        });
    }

    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public void dec(String key) {
        map.put(key, map.get(key) - 1);
    }

    public String getMaxKey() {
        return map.firstKey();
    }

    public String getMinKey() {
        return map.lastKey();
    }
}
