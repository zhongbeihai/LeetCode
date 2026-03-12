package com.simulation;

import java.util.*;

public class FindOriginalArrayFromDoubledArray_2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[0];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        int[] res = new int[n / 2];
        int j = 0;

        if (map.containsKey(0)) {
            if (map.get(0) % 2 == 1) return new int[0];
            for (int fre = 0; fre < map.get(0) / 2; fre++) {
                res[j++] = 0;
            }
            map.put(0, 0);
        }

        for (int i = 0; i < keys.size(); i++) {
            int cur = keys.get(i);
            if (cur == 0 || map.get(cur) == 0) continue;

            int cnt = map.get(cur);
            if (!map.containsKey(cur * 2) || map.get(cur * 2) < cnt) return new int[0];

            for (int fre = 0; fre < cnt; fre++) {
                res[j++] = cur;
            }

            map.put(cur * 2, map.get(cur * 2) - cnt);
            map.put(cur, 0);
        }

        return j == n / 2 ? res : new int[0];
    }

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray_2007 f= new FindOriginalArrayFromDoubledArray_2007();
        f.findOriginalArray(new int[]{0,0,0,0});
    }
}
