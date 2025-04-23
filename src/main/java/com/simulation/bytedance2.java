package com.simulation;

import java.util.Arrays;
import java.util.List;

public class bytedance2 {
    public static long equalizeBandwidth(List<Integer> servers) {
        // Write your code here
        int n = servers.size();
        int maxBandwidth = servers.stream().max(Integer::compareTo).orElse(0);

        long res = Long.MAX_VALUE;
        for(int choice = 0; choice <= 2; choice++){
            int T = maxBandwidth + choice;

            long requireWhole = 0;
            long requireOnes = 0;
            long requireTwos = 0;

            for(int server: servers){
                long diff = T - server;
                if (diff <= 0) continue;
                requireWhole += diff / 3;
                diff %= 3;
                if(diff % 2== 1){
                    requireOnes++;
                }
                requireTwos += diff / 2;
            }

            long candidate = 2 * requireWhole;
            long candidate2 = 2 * requireWhole;
            long candidate3 = 2 * requireWhole;
            candidate += 2 * Math.min(requireTwos, requireOnes);
            if (requireOnes > requireTwos){
                candidate += 2 * (requireOnes - requireTwos) - 1;
            }else {
                candidate += 2 * (requireTwos - requireOnes);
            }
            candidate2 += 2 * (requireTwos - requireOnes) - 1;
            candidate3 += 2 * (requireOnes - requireTwos);
            if (requireTwos == 2 && requireOnes == 0)candidate = Math.min(candidate, Math.min(candidate2, candidate3));
            res = Math.min(res, candidate);

        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,22,27};
        bytedance2.equalizeBandwidth(Arrays.asList(arr));
    }
}
