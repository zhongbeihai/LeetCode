package com.simulation;

import com.sun.scenario.effect.Merge;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<List<Integer>> list = new ArrayList<>();
        for (int[] i : intervals) {
            if (list.isEmpty()) {
                list.add(Arrays.stream(i).boxed().collect(Collectors.toCollection(ArrayList::new)));
                continue;
            }
            List<Integer> l = list.get(list.size() - 1);

            if (i[0] >= l.get(0) && i[0] <= l.get(1)) {
                if (i[1] > l.get(1)) {
                    l.set(1, i[1]);
                }
            } else {
                list.add(Arrays.stream(i).boxed().collect(Collectors.toCollection(ArrayList::new)));
            }

        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals_56 m = new MergeIntervals_56();
        m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
