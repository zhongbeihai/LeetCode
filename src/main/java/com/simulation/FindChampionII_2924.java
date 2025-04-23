package com.simulation;

import java.util.HashSet;

public class FindChampionII_2924 {
    public int findChampion(int n, int[][] edges) {
        if(n == 1 ) return 0;
        HashSet<Integer> node = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int[] edge: edges){
            node.add(edge[0]);
            node.add(edge[1]);
            visited.add(edge[1]);
        }
        if(n - visited.size() > 1) return -1;
        node.removeAll(visited);
        if(node.size() > 1) return -1;
        return node.iterator().next();
    }

    public static void main(String[] args) {
        FindChampionII_2924 f = new FindChampionII_2924();
        f.findChampion(2, new int[][]{{0,1},{1,2}});
    }
}
