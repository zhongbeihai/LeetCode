package com.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BuildingWithOceanView_1762 {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> res = new ArrayList<>();

        int rightTallest = n - 1;
        res.add(rightTallest);
        for (int i = n - 2; i >= 0; i--){
            if (heights[i] > heights[rightTallest]){
                res.add(i);
                rightTallest = i;
            }
        }

        Collections.reverse(res);
        return  res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        BuildingWithOceanView_1762 b = new BuildingWithOceanView_1762();
        b.findBuildings(new int[]{4,3,2,1});
    }
}
