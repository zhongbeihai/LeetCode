package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class AvoidFloodInTheCity_1488 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];

        TreeSet<Integer> dryDays = new TreeSet<>();
        HashMap<Integer, Integer> lastRain = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0){
                res[i] = -1;
                if (lastRain.containsKey(lake)){
                    int lastDay = lastRain.get(lake);
                    Integer dryDay = dryDays.higher(lastDay);
                    if (dryDay == null) return new int[0];
                    res[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lastRain.put(lake, i);
            }else {
                dryDays.add(i);
                res[i] = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AvoidFloodInTheCity_1488 a = new AvoidFloodInTheCity_1488();
        // a.avoidFlood(new int[]{1,0,2,0,2,1});
        a.avoidFlood(new int[]{0,1,1});
    }
}
