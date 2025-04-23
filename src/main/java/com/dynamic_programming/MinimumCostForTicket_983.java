package com.dynamic_programming;

import java.util.Arrays;

public class MinimumCostForTicket_983 {
    public int mincostTickets(int[] days, int[] costs) {

        int dayLen = days[days.length - 1];
        int[] dp = new int[dayLen + 1];
        Arrays.fill(dp, 500);
        dp[0] = 0;
        for (int i = 0; i < days.length; i++){
            int j = days[i];
            int p = j - 1 >= 0 ? days[j - 1] : 0;
            dp[j] = Math.min(dp[j],dp[p - 1]  + costs[0]);
            if(p - 7 >=0) dp[j] = Math.min(dp[j], dp[p - 7] + costs[1]);
            if(p - 30 >= 0)  dp[j] = Math.min(dp[j], dp[p - 30] + costs[2]);
        }
        return dp[days[days.length - 1]];
    }

    public static void main(String[] args) {
        MinimumCostForTicket_983 minimumCostForTicket983 = new MinimumCostForTicket_983();
        minimumCostForTicket983.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15});
    }
}
