package com.search;

public class RedundentConnection_684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n + 1];

        for (int i = 1; i <= n; i++){
            parents[i] = i;
        }

        int[] res = new int[]{0, 0};
        for (int[] edge: edges){
            int u = find(edge[0], parents), v = find(edge[1], parents);
            if (u == v){
                res = edge;
            }else {
                parents[v] = u;
            }
        }

        return res;
    }

    public int find(int i, int[] parents){
        int parent = i;
        if (parents[i] != i){
            parent = find(parents[i], parents);
        }
        return parent;
    }
}
