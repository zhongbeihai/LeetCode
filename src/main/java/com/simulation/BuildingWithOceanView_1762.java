package com.simulation;

import java.util.*;

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
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
        //return  res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        BuildingWithOceanView_1762 b = new BuildingWithOceanView_1762();
        b.findBuildings(new int[]{4,3,2,1});
    }
}
