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
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int sp = 0, ep = 0, meetingRoomsCount = 0;

        while (sp < n){
            if (start[sp] >= end[ep]){
                meetingRoomsCount--;
                ep++;
            }
            meetingRoomsCount++;
            sp++;
        }

        return meetingRoomsCount;
    }

    public static void main(String[] args) {
        MeetingRoomsII_253 m = new MeetingRoomsII_253();
        m.twoPointerWay(new int[][]{{13,15},{1,13},{6,9}});
    }
}
