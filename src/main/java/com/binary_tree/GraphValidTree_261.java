package com.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree_261 {
    class UnionFind_251{
        int n, islands;
        int[] parent, rank;
        UnionFind_251(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            islands = n;

            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x){
            if (parent[x] == x) return x;
            else return find(parent[x]);
        }

        boolean connect(int x, int y){
            int xp = find(x), yp = find(y);
            if (xp == yp) return false;

            if (rank[xp] < rank[yp]){
                parent[xp] = yp;
                rank[yp]++;
            }else {
                parent[yp] = xp;
                rank[xp]++;
            }
            islands--;

            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        UnionFind_251 u = new UnionFind_251(n);

        for (int[] edge: edges){
            if (!u.connect(edge[0], edge[1])) return false;
        }

        return u.islands == 1;
    }

    public static void main(String[] args) {
        GraphValidTree_261 g = new GraphValidTree_261();
        g.validTree(5, new int[][]{{0,1}, {0,2}, {0,3},{1,4}});
    }
}
