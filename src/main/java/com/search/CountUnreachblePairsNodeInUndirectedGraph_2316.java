package com.search;

import java.util.HashSet;

public class CountUnreachblePairsNodeInUndirectedGraph_2316 {
    class UnionFind_2316{
        int[] parent;
        int[] rank;
        UnionFind_2316(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int findP(int n){
            if (parent[n] != n) return findP(parent[n]);
            return n;
        }

        void connect(int x, int y){
            int xp = findP(x), yp = findP(y);
            if (xp != yp){
                if (rank[xp] > rank[yp]){
                    parent[yp] = xp;
                    rank[xp]++;
                }else {
                    parent[xp] = yp;
                    rank[yp]++;
                }
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        UnionFind_2316 u = new UnionFind_2316(n);
        for (int[] edge: edges){
            u.connect(edge[0], edge[1]);
        }

        HashSet<Integer> roots = new HashSet<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int p = u.findP(i);
            if (!roots.contains(p)){
                res += n - u.rank[p];
                roots.add(p);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountUnreachblePairsNodeInUndirectedGraph_2316 c = new CountUnreachblePairsNodeInUndirectedGraph_2316();
        c.countPairs(3, new int[][]{{0,1},{0,2},{1,2}});
    }
}
