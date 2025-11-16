package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInTheCity_1488 {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> lastRains = new HashMap<>();  // <lake, day>
        TreeSet<Integer> dryDays = new TreeSet<>();

        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0){
                res[i] = -1;
                if (lastRains.containsKey(rains[i])){
                    Integer dry = dryDays.higher(lastRains.get(rains[i]));
                    if (dry == null) return new int[0];
                    dryDays.remove(dry);
                    res[dry] = rains[i];
                }
                lastRains.put(rains[i], i);
            }else {
                res[i] = 1;
                dryDays.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AvoidFloodInTheCity_1488 a = new AvoidFloodInTheCity_1488();
        // a.avoidFlood(new int[]{1,0,2,0,2,1});
        //a.avoidFlood(new int[]{0,1,1});
        a.avoidFlood(new int[]{1,2,0,0,2,1});
    }
}
