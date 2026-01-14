package com.search;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        long low = 0, high = piles[piles.length - 1];
        while (low <= high){
            long mid = low + (high - low) / 2;
            if (isValid(piles, mid, h)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return Math.toIntExact(low);
    }

    public boolean isValid(int[] piles, long mid, int h){
        for (int pile: piles){
            h -= (int) Math.ceil((double) pile / mid);
            if (h < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        KokoEatingBananas_875 k = new KokoEatingBananas_875();
        // k.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000);
        // k.isValid(new int[]{805306368,805306368,805306368}, 1000000000, 2);
        // k.minEatingSpeed(new int[]{3,6,7,11}, 8);
         k.minEatingSpeed(new int[]{312884470}, 312884469);
        // k.minEatingSpeed(new int[]{30,11,23,4,20}, 6);
    }
}
