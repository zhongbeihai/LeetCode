package com.simulation;

import java.util.*;

public class BuildingWithOceanView_1762 {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> res = new ArrayList<>();

        int right = n, left = n - 1;
        while ((left >= 0 && left < right)){
            if (right == n || heights[left] > heights[right]) {
                res.add(left);
                right = left;
            }
            left--;
        }
        Collections.reverse(res);
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }

        return r;
    }

    public static void main(String[] args) {
        BuildingWithOceanView_1762 b = new BuildingWithOceanView_1762();
        b.findBuildings(new int[]{4,3,2,1});
    }
}
