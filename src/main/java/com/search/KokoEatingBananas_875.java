package com.search;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int low = piles[0], high = piles[n - 1];
        while (low < high){
            int mid = low + (high - low) / 2;
            if (isValid(piles, mid, h)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isValid(int[] piles, int k, int h){
        int n = piles.length;
        for (int i = n - 1; i >= 0; i--){
            h -= (int) Math.max(1, Math.ceil(piles[i] / (double)k));
            if (h < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        KokoEatingBananas_875 k = new KokoEatingBananas_875();
        // k.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000);
        // k.isValid(new int[]{805306368,805306368,805306368}, 1000000000, 2);
        k.minEatingSpeed(new int[]{3,6,7,11}, 8);
    }
}
