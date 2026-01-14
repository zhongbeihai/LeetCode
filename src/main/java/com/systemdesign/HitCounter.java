package com.systemdesign;

import java.util.TreeMap;

public class HitCounter {
    int[] time = new int[300];
    int[] hits = new int[300];
    public HitCounter() {

    }

    public void hit(int timestamp) {
        int idx = timestamp % 300;
        if (time[idx] != timestamp){
            time[idx] = timestamp;
            hits[idx] = 1;
        }else {
            hits[idx]++;
        }
    }

    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (time[i] >= timestamp - 299 && time[i] <= timestamp) res += hits[i];
        }

        return res;
    }
}
