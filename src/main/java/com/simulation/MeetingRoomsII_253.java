package com.simulation;

import java.util.*;

public class MeetingRoomsII_253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int meetRoomsCount = 0;
        for (int[] interval: intervals){
            if (minHeap.isEmpty()){
                minHeap.add(interval[1]);
                meetRoomsCount++;
            }else {
                int earliestEndMeeting = minHeap.peek();
                if (earliestEndMeeting > interval[0]){
                    meetRoomsCount++;
                }else {
                    minHeap.poll();
                }
                minHeap.add(interval[0]);
            }
        }

        return meetRoomsCount;
    }

    public int twoPointerWay(int[][] intervals){
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        int i = 0;
        for (int[] interval: intervals){
            starts[i] = interval[0];
            ends[i] = interval[1];
            i++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int sp = 0, ep = 0;
        int roomNeed = 0;
        while (sp < n){
            if (starts[sp] >= ends[ep]){
                roomNeed--;
                ep++;
            }
            sp++;
            roomNeed++;
        }

        return roomNeed;
    }

    public static void main(String[] args) {
        MeetingRoomsII_253 m = new MeetingRoomsII_253();
        m.twoPointerWay(new int[][]{{13,15},{1,13},{6,9}});
    }
}
