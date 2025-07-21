package com.search;

public class CapacityToShipPackagesWithinDDays_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + weights[i - 1];
        }

        int left = 0, right = prefixSum[n];
        int res = Integer.MAX_VALUE;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (canShip(prefixSum, days, mid)){
                res = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return res;
    }

    public boolean canShip(int[] prefixSum, int days, int capacity){
        int cnt = 1, startShipPackage = 0;
        for (int i = 0; i < prefixSum.length - 1; i++) {
            if (prefixSum[i + 1] - prefixSum[i] > capacity) return false;

            if (prefixSum[i + 1] - prefixSum[startShipPackage] > capacity){
                cnt++;
                startShipPackage = i;
            }

            if (cnt > days) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays_1011 d = new CapacityToShipPackagesWithinDDays_1011();
        d.shipWithinDays(new int[]{1,2,3,1,1}, 4);
    }
}
