package com.search;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 0, max = Arrays.stream(piles).max().getAsInt();
        while (min < max){
            int mid = (max + min) / 2;
            if (isValid(piles, h, mid)){
                max = mid;
            }else {
                min = mid + 1;
            }
        }

        return min;
    }

    public boolean isValid(int[] piles, int h, int k){
        double count = 0;
        for (int pile: piles){
            count +=  Math.ceil(pile / (double) k);
        }

        return count <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas_875 k = new KokoEatingBananas_875();
        // k.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000);
        k.isValid(new int[]{805306368,805306368,805306368}, 1000000000, 2);
    }
}
