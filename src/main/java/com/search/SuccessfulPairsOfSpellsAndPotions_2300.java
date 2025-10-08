package com.search;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int numPotions = potions.length;

        int[] res = new int[spells.length];
        int i = 0;
        for (int spell: spells){
            int idx = getFirstAvailablePotions(potions, (long)spell, success);
            res[i++] = numPotions - idx;
        }

        return res;
    }

    public int getFirstAvailablePotions(int[] potions, long spell, long success){
        int l = 0, r = potions.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (potions[mid] * spell >= success){
                r = mid;
            }else {
                l= mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        SuccessfulPairsOfSpellsAndPotions_2300 s = new SuccessfulPairsOfSpellsAndPotions_2300();
        s.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7);
    }
}
