package com.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class MaximumProfitInJpbScheduling_1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(i -> i[1]));

        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++){
            int include = jobs[i][2];
            int last = findAvailable(jobs, i, jobs[i][0]);
            if (last != -1) {
                include += dp[last];
            }
            dp[i] = Math.max(dp[i - 1], include);
        }

        return dp[n - 1];
    }

    public  int findAvailable(int[][] jobs, int end, int startTime){
        int left = 0, right = end - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= startTime) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumProfitInJpbScheduling_1235 m = new MaximumProfitInJpbScheduling_1235();
        m.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70});
    }
}
