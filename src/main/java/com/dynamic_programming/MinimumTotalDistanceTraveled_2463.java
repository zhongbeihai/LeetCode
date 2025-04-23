package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTotalDistanceTraveled_2463 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int[][] dp = new int[robot.size()][factory.length];
        for(int[] d: dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        Collections.sort(robot);
        Arrays.sort(factory, (o1, o2) ->  o1[0] - o2[0]);

        dp[0][0] = Math.abs(factory[0][0] - robot.get(0));
        factory[0][1]--;

        for(int i = 1; i < robot.size(); i++){
            int cloestFac = 0;
            for (int j = 0; j < factory.length; j++){
                if(factory[j][1] == 0) continue;
                if(dp[i - 1][j] + Math.abs(factory[j][0] - robot.get(i)) < dp[i][j]) {
                    cloestFac = j;
                    dp[i][j] = dp[i - 1][j] + Math.abs(factory[j][0] - robot.get(i));
                }
            }
            factory[cloestFac][1]--;
        }

        return Arrays.stream(dp[robot.size() - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        MinimumTotalDistanceTraveled_2463 m = new MinimumTotalDistanceTraveled_2463();
        ArrayList<Integer> l = new ArrayList<>();
        int[] a = new int[]{0,4,6};
        l.add(0);
        l.add(4);
        l.add(6);
        m.minimumTotalDistance(l, new int[][]{{2,2}, {6,2}});
    }
}
