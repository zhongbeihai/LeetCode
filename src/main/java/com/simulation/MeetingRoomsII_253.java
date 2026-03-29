package com.simulation;

import com.backtrack.NQueens_51;

import java.util.*;

public class MeetingRoomsII_253 {
    // sort the meetings by start time
    // use min-heap to track the earliest available meeting room
    // for a meeting
    //      1. start time > the earliest available meeting room -> reuse that meeting room
    //      2. need a meeting room
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // ele -> ending time of the meetings

        int rooms = 0;
        for (int[] m: intervals){
            int start = m[0], end = m[1];
            if (pq.isEmpty() || start < pq.peek()) {
                rooms++;
            }else {
                pq.poll();
            }
            pq.add(end);
        }

        return rooms;
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
        m.minMeetingRooms(new int[][]{{13,15},{1,13},{6,9}});
    }
}
