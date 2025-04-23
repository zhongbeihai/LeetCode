package com.search;

public class MinimumTimeToRepairCars_2594 {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = 0;
        for (int rank: ranks) maxRank = Math.max(rank, maxRank);
        long low = 0, high = (long) cars * cars * maxRank;
        while (low <= high){
            long mid = low + (high - low) / 2;
            if (isValid(ranks, cars, mid)){
                high = mid - 1;
            }else {
                low = mid  + 1;
            }
        }

        return low;
    }

    public boolean isValid(int[] ranks, int cars, long time){
        for (int rank : ranks){
            double canRepair = Math.floor(Math.sqrt(time / rank));
            cars -= canRepair;

            if (cars <= 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumTimeToRepairCars_2594 m = new MinimumTimeToRepairCars_2594();
        // m.repairCars(new int[]{4,2,3,1}, 10);
        m.repairCars(new int[]{3}, 52);
    }
}
