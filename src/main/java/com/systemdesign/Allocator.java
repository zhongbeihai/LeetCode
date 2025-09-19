package com.systemdesign;

import java.util.*;

public class Allocator {
    private final TreeMap<Integer, Integer> free = new TreeMap<>();
    private final Map<Integer, List<int[]>> used = new HashMap<>();

    public Allocator(int n){
        if (n > 0) free.put(0, n - 1);
    }

    public int allocate(int size, int mID){
        if (size <= 0) return -1;

        Integer pickL = null, pickR = null;
        for (Map.Entry<Integer, Integer> e: free.entrySet()){
            int l = e.getKey(), r = e.getValue();
            if (r - l + 1 > size) {pickL = l; pickR = r; break;}
        }

        if (pickL == null) return -1;
        int L = pickL, R = pickL + size - 1;
        used.computeIfAbsent(mID, k -> new ArrayList<>()).add(new int[]{L, R});
        free.remove(pickL);
        if (R < pickR) free.put(R + 1, pickR);

        return L;
    }

    public int freeMemory(int mID) {
        List<int[]> segs = used.get(mID);
        if (segs == null || segs.isEmpty()) return 0;

        int freed = 0;
        for (int[] s: segs){
            int l = s[0], r = s[1];
            freed += r - l + 1;

            // merge
            Map.Entry<Integer, Integer> le = free.floorEntry(l);
            if (le != null && le.getValue() + 1 >= l){
                l = Math.min(l, le.getKey());
                r = Math.max(r, le.getValue());
                free.remove(le.getKey());
            }
        }
    }
}
