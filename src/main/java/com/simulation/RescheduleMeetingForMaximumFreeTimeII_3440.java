package com.simulation;

import java.util.*;

public class RescheduleMeetingForMaximumFreeTimeII_3440 {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        // Step 1: build meetings array and sort
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = startTime[i];
            meetings[i][1] = endTime[i];
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Step 2: build gaps and map (gapLen -> List of [start])
        TreeMap<Integer, List<int[]>> gapMap = new TreeMap<>();
        List<int[]> gaps = new ArrayList<>();

        // build all gaps
        if (meetings[0][0] > 0) {
            int len = meetings[0][0];
            gaps.add(new int[]{0, meetings[0][0]});
            gapMap.computeIfAbsent(len, k -> new ArrayList<>()).add(new int[]{0, meetings[0][0]});
        }

        for (int i = 1; i < n; i++) {
            int gapStart = meetings[i - 1][1];
            int gapEnd = meetings[i][0];
            if (gapEnd > gapStart) {
                int len = gapEnd - gapStart;
                gaps.add(new int[]{gapStart, gapEnd});
                gapMap.computeIfAbsent(len, k -> new ArrayList<>()).add(new int[]{gapStart, gapEnd});
            }
        }

        if (eventTime > meetings[n - 1][1]) {
            int len = eventTime - meetings[n - 1][1];
            gaps.add(new int[]{meetings[n - 1][1], eventTime});
            gapMap.computeIfAbsent(len, k -> new ArrayList<>()).add(new int[]{meetings[n - 1][1], eventTime});
        }

        // Step 3: baseline answer: no move
        int maxGap = gapMap.isEmpty() ? 0 : gapMap.lastKey();

        // Step 4: try removing each meeting
        for (int i = 0; i < n; i++) {
            int duration = meetings[i][1] - meetings[i][0];

            // compute merged gap if removing meeting[i]
            int mergedStart = 0, mergedEnd = 0;
            if (i == 0) {
                mergedStart = 0;
                mergedEnd = meetings[1][0];
            } else if (i == n - 1) {
                mergedStart = meetings[n - 2][1];
                mergedEnd = eventTime;
            } else {
                mergedStart = meetings[i - 1][1];
                mergedEnd = meetings[i + 1][0];
            }

            int mergedLen = Math.max(0, mergedEnd - mergedStart);

            // try inserting into some valid gap (gap ≥ duration)
            Map.Entry<Integer, List<int[]>> entry = gapMap.ceilingEntry(duration);
            if (entry != null) {
                int candidateGapLen = entry.getKey();
                maxGap = Math.max(maxGap, Math.max(candidateGapLen - duration, mergedLen));
            } else {
                // even if no gap can hold this meeting, maybe mergedLen is the best
                maxGap = Math.max(maxGap, mergedLen);
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        RescheduleMeetingForMaximumFreeTimeII_3440 r = new RescheduleMeetingForMaximumFreeTimeII_3440();
        r.maxFreeTime(5, new int[]{1,3}, new int[]{2,5});
    }

}
