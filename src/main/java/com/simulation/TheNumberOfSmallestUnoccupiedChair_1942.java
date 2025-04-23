package com.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class TheNumberOfSmallestUnoccupiedChair_1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        int arr = times[targetFriend][0], left = times[targetFriend][1];
        int[][] orig = Arrays.copyOf(times, times.length);
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        ArrayList<Integer> s = new ArrayList<>();
        for(int i = 0; i <= arr; i++){
            int seat = 0;
            if(s.isEmpty()) {
                s.add(times[i][1]);
            }else{
                boolean re = false;
                for(int j = 0; j < s.size(); j++){
                    if(s.get(j) <= times[i][0]){
                        s.set(j, times[i][1]);
                        re = true;
                        seat = j;
                        break;
                    }
                }
                if(!re){
                    s.add(times[i][1]);
                    seat = s.size() - 1;
                }
            }
            if(times[i][0] == arr) return seat;
        }
        return -1;
    }

    public static void main(String[] args) {
        TheNumberOfSmallestUnoccupiedChair_1942 t = new TheNumberOfSmallestUnoccupiedChair_1942();
        t.smallestChair(new int[][]{{1,4},{2,3},{4,6}}, 1);
    }
}
