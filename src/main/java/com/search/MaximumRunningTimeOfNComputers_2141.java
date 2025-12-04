package com.search;

public class MaximumRunningTimeOfNComputers_2141 {
    public long maxRunTime(int n, int[] batteries) {
        long low = 0, high = Long.MAX_VALUE;

        while (low < high){
            long mid = low + (high - low + 1) / 2;
            if (isAval(n, batteries, mid)){
                low = mid;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }

    public boolean isAval(int n, int[] batteries, long time){
        long total = 0;
        for (int batter: batteries){
            total += Math.min(batter, time);
        }
        return total >= time * n;
    }
}
