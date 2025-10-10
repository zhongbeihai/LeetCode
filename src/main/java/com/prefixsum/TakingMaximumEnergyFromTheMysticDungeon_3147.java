package com.prefixsum;

public class TakingMaximumEnergyFromTheMysticDungeon_3147 {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = n -1; i >= 0; i--){
            int cont = (i + k < n) ? i + k : 0;
            dp[i] = energy[i] + dp[cont];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        TakingMaximumEnergyFromTheMysticDungeon_3147 t = new TakingMaximumEnergyFromTheMysticDungeon_3147();
        t.maximumEnergy(new int[]{-9,-2,-6,-5,-8,3,0}, 1);
    }
}
