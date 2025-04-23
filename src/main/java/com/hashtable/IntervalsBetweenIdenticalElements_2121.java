package com.hashtable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntervalsBetweenIdenticalElements_2121 {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                List<Integer> l = map.get(arr[i]);
                l.add(i);
                map.put(arr[i], l);
            }else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(arr[i], l);
            }
        }

        long[] res = new long[arr.length];
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            IntStream.range(0, entry.getValue().size()).forEach(i -> {
                int current = entry.getValue().get(i);
                res[current] = entry.getValue().stream()
                        .mapToLong(other -> Math.abs(current - other)).sum();
            });
        }

        return res;
    }

    public static void main(String[] args) {
        IntervalsBetweenIdenticalElements_2121 i = new IntervalsBetweenIdenticalElements_2121();
        i.getDistances(new int[]{2,1,3,1,2,3,3});
    }
}
