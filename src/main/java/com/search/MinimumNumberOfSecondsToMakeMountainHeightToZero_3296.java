package com.search;

public class MinimumNumberOfSecondsToMakeMountainHeightToZero_3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long minTime = Integer.MAX_VALUE, low = 0, high = 10000000;

        while (low <= high){
            long mid = (high + low) / 2;
            if (canReduceUnderZero(mountainHeight, workerTimes, mid)){
                minTime = Math.min(minTime, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return minTime;
    }

    public boolean canReduceUnderZero(int mountainHeight, int[] workerTimes, long maxWorkTime){
        long totalReduce = 0;
        for (int efficiency: workerTimes){
            long low = 1, high = mountainHeight;
            while (low <= high){
                long job = (low + high) / 2;
                long cost = (job * (1 + job)) / 2 * efficiency;
                if (cost <= maxWorkTime){
                    low = job + 1;
                }else {
                    high = job - 1;
                }
            }

            totalReduce += high;
            if (totalReduce >= maxWorkTime) return true;
        }

        return totalReduce >= maxWorkTime;
    }
}
