package com.binary_tree;

import java.util.Arrays;

public class Heaters_475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        long low = 0, high = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (low <= high){
            long mid = low + (high - low) / 2;
            if (isValid(houses, heaters, mid)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return (int)low;
    }

    public boolean isValid(int[] houses, int[] heaters, long radius){
        int h = 0;
        for (int i = 0; i < houses.length; i++){
            while (Math.abs(houses[i] - heaters[h]) > radius) {
                h++;
                if (h >= heaters.length) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Heaters_475 h = new Heaters_475();
        // h.findRadius(new int[]{1,5}, new int[]{10});
        h.findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},
                new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612});
    }
}
