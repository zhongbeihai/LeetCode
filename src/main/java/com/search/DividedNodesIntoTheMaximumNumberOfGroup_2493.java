package com.search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DividedNodesIntoTheMaximumNumberOfGroup_2493 {
    public int magnificentSets(int n, int[][] edges) {
        int[] inDeg = new int[n + 1];
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            map.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            inDeg[edge[0]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        List<Integer> startNodes = new ArrayList<>();
        for (int i: inDeg){
            if (inDeg[i] == 0) startNodes.add(i);
        }

        int[] groupMap = new int[n + 1];
        int maxGroup = 1;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int startNode: startNodes){
            queue.add(new Pair<>(startNode, maxGroup));
            while (!queue.isEmpty()){
                Pair<Integer, Integer> pair = queue.poll();
                int curNode = pair.getKey(), curGroup = pair.getValue();
                maxGroup = Math.max(maxGroup, curGroup);
                groupMap[curNode] = curGroup;
                for (Integer node: map.get(curNode)){
                    if (groupMap[node] == 0) queue.add(new Pair<>(node, curGroup + 1));
                }
            }
        }
        return maxGroup;
    }
}
