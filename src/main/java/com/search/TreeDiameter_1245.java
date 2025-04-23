package com.search;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.*;

public class TreeDiameter_1245 {
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) return -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge: edges){
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            if (entry.getValue().size() == 1) queue.add(entry.getKey());
        }

        int diameter = 0;

        while (queue.size() > 1){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int node = queue.poll();
                List<Integer> l = map.get(node);
                for (int nn: l){
                    map.get(nn).remove(Integer.valueOf(node));
                    if (map.get(nn).size() == 1) queue.offer(nn);
                }
            }

            diameter += 2;
        }
        return queue.size() == 1 ? diameter : diameter - 1;
    }

    public static void main(String[] args) {
        TreeDiameter_1245 t = new TreeDiameter_1245();
        t.treeDiameter(new int[][]{{0,1},{1,2},{2,3},{1,4},{4,5}});
    }
}
