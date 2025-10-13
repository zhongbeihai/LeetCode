package com.dynamic_programming;

import java.util.*;

public class MaximumTotalDamageWithSpellCasting_3186 {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> fre = new HashMap<>();
        for (int p: power){
            fre.put(p, fre.getOrDefault(p, 0) + 1);
        }

        List<Integer> key = new ArrayList<>(fre.keySet());
        Collections.sort(key);
        int n = key.size();
        long[] dp = new long[n];
        long res = 0;
        for (int i = 0; i < n; i++){
            int thisKey = key.get(i);
            int j = i - 1;
            while (j >= 0){
                if (key.get(j) > thisKey - 3) j--;
                else break;
            }
            long take  = (long) fre.get(thisKey) * thisKey;
            if (j >= 0) take += dp[j];

            long skip = i > 0 ? dp[i - 1]: 0;
            dp[i] = Math.max(skip, take);

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting_3186 m = new MaximumTotalDamageWithSpellCasting_3186();
        m.maximumTotalDamage(new int[]{7,1,6,6});
    }
}
