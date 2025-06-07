package com.search;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTress_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        List<List<Integer>> ajaGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {ajaGraph.add(new ArrayList<>());}

        for (int[] edge: edges){
            ajaGraph.get(edge[0]).add(edge[1]);
            ajaGraph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ajaGraph.get(i).size() == 1) leaves.add(i);
        }

        int remainNode = n;
        while(remainNode > 2){
            remainNode -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf: leaves){
                int neighbour = ajaGraph.get(leaf).iterator().next();
                ajaGraph.get(neighbour).remove(Integer.valueOf(leaf));

                if (ajaGraph.get(neighbour).size() == 1) newLeaves.add(neighbour);
            }

            leaves = newLeaves;
        }

        result.addAll(leaves);
        return result;
    }

    public static void main(String[] args) {
        MinimumHeightTress_310 m = new MinimumHeightTress_310();
        m.findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});
    }
}
