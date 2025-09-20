package com.systemdesign;

import java.util.*;

public class Router {
    private static final class Key {
        final int s, d, t;
        Key(int s, int d, int t) { this.s = s; this.d = d; this.t = t; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key k = (Key) o;
            return s == k.s && d == k.d && t == k.t;
        }
        @Override public int hashCode() {
            int h = 146527;
            h = h * 31 + s;
            h = h * 31 + d;
            h = h * 31 + t;
            return h;
        }
    }

    private final Deque<Key> queue = new ArrayDeque<>();
    private final Set<Key> set = new HashSet<>();
    private final HashMap<Integer, TreeMap<Integer, Integer>> byDest = new HashMap<>();
    private final int limit;
    public Router(int memoryLimit) {
        this.limit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        if (limit == 0) return false;
        Key packet = new Key(source, destination, timestamp);
        if (!set.add(packet)) return false;

        if (queue.size() == this.limit){
            evictOldest();
        }
        queue.addLast(packet);
        byDest.computeIfAbsent(destination, k -> new TreeMap<>())
                .merge(timestamp, 1, Integer::sum);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        Key packet = queue.pollFirst();
        set.remove(packet);
        TreeMap<Integer, Integer> tm = byDest.get(packet.d);
        if (tm != null){
            int cnt = tm.getOrDefault(packet.t, 0) - 1;
            if (cnt <= 0) tm.remove(packet.t);
            else tm.put(packet.t, cnt);
            if (tm.isEmpty()) byDest.remove(packet.d);
        }

        return new int[]{packet.s, packet.d, packet.t};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (startTime > endTime) return 0;

        TreeMap<Integer, Integer> tm = byDest.get(destination);
        if (tm == null|| tm.isEmpty()) return 0;

        if (tm.firstKey() > endTime || tm.lastKey() < startTime) return 0;
        int sum = 0;
        for (int v : tm.subMap(startTime, true, endTime, true).values()) {
            sum += v;
        }
        return sum;
    }

    private void evictOldest(){
        Key packet = queue.pollFirst();;
        if (packet == null) return;

        set.remove(packet);

        TreeMap<Integer, Integer> tm = byDest.get(packet.d);
        if (tm != null){
            int cnt = tm.getOrDefault(packet.t, 0) - 1;
            if (cnt <= 0) tm.remove(packet.t);
            else tm.put(packet.t, cnt);
            if (tm.isEmpty()) byDest.remove(packet.d);
        }
    }
}
