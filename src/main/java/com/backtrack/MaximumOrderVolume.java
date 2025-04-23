package com.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MaximumOrderVolume {
    private static int maxVo = 0;
    public static int phoneCalls(List<Integer> start, List<Integer> duration, List<Integer> volume) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < start.size(); i++){
            list.add(new int[]{start.get(i), duration.get(i), volume.get(i)});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);

        backtrack(list, 0, 0, 0);
        return maxVo;
    }

    public static void backtrack(List<int[]> list,
                                 int nextTime, int curVo, int pos){
        maxVo = Math.max(curVo, maxVo);

        for (int i = pos; i < list.size(); i++){
            int preN = nextTime;
            if (list.get(i)[0] > nextTime){
                curVo += list.get(i)[2];
                nextTime = list.get(i)[0] + list.get(i)[1];

                backtrack(list, nextTime, curVo, i + 1);

                curVo -= list.get(i)[2];
                nextTime = preN;
            }

        }

    }
}
