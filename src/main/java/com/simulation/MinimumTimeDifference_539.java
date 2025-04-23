package com.simulation;

import java.util.*;

public class MinimumTimeDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] p = timePoints.get(i).split(":");
            ArrayList<Integer> pair = new ArrayList<>();
            if(Objects.equals(p[0], "00") && Objects.equals(p[1], "00")){
                p[0] = "24";
                p[1] = "00";
            }
            arr[i] = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        }
        Arrays.sort(arr);

        int minn = 1440 - arr[arr.length - 1] + arr[0];
        for(int i = 1; i < arr.length; i++){
            int min = arr[i] - arr[i-1];
            if ( min < minn) minn = min;
        }

        return minn;
    }

    public static void main(String[] args) {
        ArrayList<String> timePoints = new ArrayList<>();
        timePoints.add("05:31");
        timePoints.add("00:35");
        timePoints.add("22:08");

        MinimumTimeDifference_539 m = new MinimumTimeDifference_539();
        m.findMinDifference(timePoints);
    }
}
