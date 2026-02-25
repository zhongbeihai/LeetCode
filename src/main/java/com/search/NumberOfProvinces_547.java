package com.search;

public class NumberOfProvinces_547 {
    class UnionFind{
        int[] parent;
        int[] rank;
        int islands;
        UnionFind(int n){
            this.islands = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        int findParent(int node){
            if (parent[node] == node) return node;
            else return findParent(parent[node]);
        }

        void connect(int x, int y){
            int xParent = findParent(x), yParent = findParent(y);
            if (xParent != yParent){
                if (rank[xParent] < rank[yParent]){
                    parent[xParent] = yParent;
                    rank[yParent]++;
                }else {
                    parent[yParent] = xParent;
                    rank[xParent]++;
                }
                islands--;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int[] map = isConnected[i];
            for (int j = 0; j < map.length; j++) {
                if (map[j] == 1)u.connect(i, j);
            }
        }

        return u.islands;
    }
}
