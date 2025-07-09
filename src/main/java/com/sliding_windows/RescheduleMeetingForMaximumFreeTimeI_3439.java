package com.sliding_windows;

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingForMaximumFreeTimeI_3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> gap = new ArrayList<>();
        if (startTime[0] != 0) gap.add(startTime[0]);
        for (int i = 0; i < n - 1; i++){
            gap.add(startTime[i + 1] - endTime[i]);
        }
        if (endTime[n - 1] != eventTime) gap.add(eventTime - endTime[n - 1]);

        int right = 0, cur = 0;
        int res = 0;
        for (int i = 0; i < gap.size(); i++){
            while (right < gap.size() && right - i < k + 1){
                cur += gap.get(right);
                right++;
            }

            res = Math.max(res, cur);
            cur -= gap.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        RescheduleMeetingForMaximumFreeTimeI_3439 r = new RescheduleMeetingForMaximumFreeTimeI_3439();
        // r.maxFreeTime(10, 1, new int[]{0,2,9}, new int[]{1, 4, 10});
        // r.maxFreeTime(5, 2, new int[]{0,1,2,3,4}, new int[]{1,2,3,4,5});
        r.maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5});
    }
}
