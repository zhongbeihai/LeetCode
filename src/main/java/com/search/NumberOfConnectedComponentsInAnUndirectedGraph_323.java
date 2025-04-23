package com.search;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
    static class UnionFind {
        public int[] parent;
        Set<Integer> set;
        public UnionFind(int size){
            parent = new int[size];
            set = new HashSet<>();
            for (int i = 0; i < size; i++){
                parent[i] = i;
                set.add(i);
            }
        }

        public int findParent(int n){
            if (parent[n] == n) return n;
            parent[n] = findParent(parent[n]);
            return parent[n];
        }

        public void union(int x, int y){
            int pX = findParent(x);
            int pY = findParent(y);
            if (pX == pY) return;
            parent[pX] = pY;
            set.remove(pX);
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind u = new UnionFind(n);
        for (int[] edge: edges){
            u.union(edge[0], edge[1]);
        }

        return u.set.size();
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph_323 n = new NumberOfConnectedComponentsInAnUndirectedGraph_323();
        n.countComponents(5, new int[][]{{0,1},{0,1},{1,2},{3,4}});
    }
}
