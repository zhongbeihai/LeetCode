package com.greedy;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class AdvantageShuffle_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++){
            if (map.ceilingKey(nums2[i]) != null){
                int c = map.ceilingKey(nums2[i] + 1);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
                res[i] = c;
            }
        }
        ArrayDeque<Integer> rest = new ArrayDeque<>();
        for(int key: map.keySet()){
            for (int i = 0; i < map.get(key); i++){
                rest.add(key);
            }
        }
        for (int i = 0; i < nums1.length; i++){
            if (res[i] == -1) res[i] = rest.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        AdvantageShuffle_870 a = new AdvantageShuffle_870();
        a.advantageCount(new int[]{15,15,4,5,0,1,7,10,3,1,10,10,8,2,3}, new int[]{4,13,14,0,14,14,12,3,15,12,2,0,6,9,0});
    }
}
