package com.dynamic_programming;

import java.util.*;

public class MaximumTotalDamageWithSpellCasting_3186 {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> fre = new HashMap<>();
        for (int p: power){
            fre.put(p, fre.getOrDefault(p, 0) + 1);
        }

        List<Integer> spellKind = new ArrayList<>(fre.keySet());
         Collections.sort(spellKind);

         long[] dp = new long[spellKind.size()];
         for (int i = 0; i < spellKind.size(); i++){
             int j = i - 1;
             while (j >= 0){
                 if (spellKind.get(j) > spellKind.get(i) - 3) j--;
                 else break;
             }
             long take = j >= 0 ? dp[j] : 0;
             take += (long) spellKind.get(i) * fre.get(spellKind.get(i));
             long skip = i - 1 >= 0 ? dp[i - 1] : 0;

             dp[i] = Math.max(take, skip);
         }

         return dp[spellKind.size() - 1];
    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting_3186 m = new MaximumTotalDamageWithSpellCasting_3186();
        m.maximumTotalDamage(new int[]{7,1,6,6});
    }
}
