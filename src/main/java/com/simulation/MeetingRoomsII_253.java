package com.simulation;

import com.backtrack.NQueens_51;

import java.util.*;

public class MeetingRoomsII_253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        int totalMeetRoom = 0, availMeetRoom = 0;
        PriorityQueue<Integer> meetingIn = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            while (!meetingIn.isEmpty() && meetingIn.peek() <= s){
                meetingIn.poll();
                availMeetRoom++;
            }
            if (availMeetRoom > 0){
                availMeetRoom--;
            }else {
                totalMeetRoom++;
            }
            meetingIn.add(e);
        }

        return totalMeetRoom;
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
