package com.binary_tree;

import java.util.*;

public class MostProfitablePathInATree_2467 {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<Integer>[] graphs = new List[amount.length];
        for (int[] edge: edges){
            if (graphs[edge[0]] == null){
                List<Integer> l = new ArrayList<>();
                l.add(edge[1]);
                graphs[edge[0]] = l;
            }else {
                graphs[edge[0]].add(edge[1]);
            }

            if (graphs[edge[1]] == null){
                List<Integer> l = new ArrayList<>();
                l.add(edge[0]);
                graphs[edge[1]] = l;
            }else {
                graphs[edge[1]].add(edge[0]);
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        dfsToRoot(graphs, bob, path, -1);

        int[] bobPath = new int[amount.length];
        Arrays.fill(bobPath, -1);
        for (int i = 0; i < path.size(); i++) {
            bobPath[path.get(i)] = i;
        }

        return dfsToMax(graphs, 0, bobPath, 0, -1, amount, 0);
    }

    public boolean dfsToRoot(List<Integer>[] graphs, int bob, List<Integer> path, int parentNode){
        if (bob == 0) return true;

        for (int neighbor: graphs[bob]){
            if (neighbor != parentNode){
                path.add(bob);
                if (dfsToRoot(graphs, neighbor, path, bob)) return true;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    public int dfsToMax(List<Integer>[] graphs, int curNode, int[] bobPath, int count,
                        int parentNode, int[] amount, int timeStamp){
        if (bobPath[curNode] == -1 || timeStamp < bobPath[curNode]){
            count += amount[curNode];
        }else if (bobPath[curNode] == timeStamp){
            count += amount[curNode] / 2;
        }

        if (graphs[curNode].size() == 1 && curNode != 0) return count;
        int nMax = Integer.MIN_VALUE;
        for (int neighbor: graphs[curNode]){
            if (neighbor != parentNode){
                nMax = Math.max(nMax, dfsToMax(graphs, neighbor, bobPath, 0, curNode, amount, timeStamp + 1));
            }
        }

        return count + nMax;
    }

    public static void main(String[] args) {
        MostProfitablePathInATree_2467 m = new MostProfitablePathInATree_2467();
        m.mostProfitablePath(new int[][]{{0,1}}, 1, new int[]{-7280,2350});
    }
}
