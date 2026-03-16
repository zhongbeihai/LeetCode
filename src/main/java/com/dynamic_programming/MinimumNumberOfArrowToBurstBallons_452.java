package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumNumberOfArrowToBurstBallons_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(i -> i[0]));

        List<int[]> res = new ArrayList<>();
        res.add(points[0]);
        for(int i = 1; i < points.length; i++){
            int[] last = res.get(res.size() - 1), cur = points[i];

            if (cur[0] <= last[1]){
                last[0] = Math.max(last[0], cur[0]);
                last[1] = Math.min(last[1], cur[1]);
            }else {
                res.add(cur);
            }
        }

        return res.size();
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowToBurstBallons_452 m = new MinimumNumberOfArrowToBurstBallons_452();
        m.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});
        m.findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}});
    }
}
