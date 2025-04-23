package com.simulation;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.zip.InflaterInputStream;

public class ReorganizeString_767 {
    // rearrange the characters in the string, so that any adjacent characters are not the same
    public String reorganizeString(String s) {
        if (s.length() == 1) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2){
            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();

            sb.append(c1).append(c2);

            map.put(c1, map.get(c1) - 1);
            map.put(c2, map.get(c2) - 1);

            if (map.get(c1) > 0) maxHeap.add(c1);
            if (map.get(c2) > 0) maxHeap.add(c2);
        }

        if (!maxHeap.isEmpty()){
            char c = maxHeap.poll();
            if (sb.length() == 0 || c == sb.charAt(sb.length() - 1) || map.get(c) > 1) return "";
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString_767 r = new ReorganizeString_767();
        r.reorganizeString("bbbbbbb");
    }
}
