package com.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberOfEventThatCanBeAttendedII_1751 {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(i -> i[1]));
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++){
            // 1. skip this event -> dp[i][j] = dp[i - 1][j]
            // 2. use this event -> dp[i][j] = dp[lastAvailable + 1][j - 1]
            int startTime = events[i-1][0], val = events[i-1][2];
            int lastAvailableEvent = findLastAvailableEvent(startTime, events, i - 1);
            for (int j = 1; j <= k; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[lastAvailableEvent + 1][j - 1] + val);
            }
        }

        return dp[n][k];
    }

    public int findLastAvailableEvent(int startTime, int[][] events, int right){
        int left = 0, res = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (events[mid][1] < startTime){
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return res;
    }
}
