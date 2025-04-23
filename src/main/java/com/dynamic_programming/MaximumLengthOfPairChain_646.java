package com.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain_646 {
    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, ((o1, o2) -> {return o1[1] - o2[1];}));
        Arrays.fill(dp, 1);

        for(int i = 1; i < pairs.length; i++){

            for(int j = 0; j < i; j++){
                if(pairs[i][0] > pairs[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = Arrays.stream(dp).max().getAsInt();
        return res;
    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain_646 m = new MaximumLengthOfPairChain_646();
        m.findLongestChain(new int[][]{{1,2},{2,3},{3,4}});
    }
}
