package com.search;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        if (h == piles.length) return piles[n - 1];
        long low = 1, high = piles[n - 1];
        while (low < high){
            long mid = low + (high - low) / 2;
            if (isValid(piles, mid, h)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    public boolean isValid(int[] piles, long mid, int h){
        double cnt = 0;
        for(int pile: piles){
            cnt += Math.ceil((double) pile / mid);
            if (cnt > h) return false;
        }

        return cnt <= h;
    }


    public static void main(String[] args) {
        KokoEatingBananas_875 k = new KokoEatingBananas_875();
        // k.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000);
        // k.isValid(new int[]{805306368,805306368,805306368}, 1000000000, 2);
        // k.minEatingSpeed(new int[]{3,6,7,11}, 8);
        // k.minEatingSpeed(new int[]{312884470}, 312884469);
        k.minEatingSpeed(new int[]{30,11,23,4,20}, 6);
    }
}
