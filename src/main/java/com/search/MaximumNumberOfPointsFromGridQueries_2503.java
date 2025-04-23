package com.search;

import com.binary_tree.MaximumCandiesAllocatedToKChildren_2226;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class UnionFind{
    int[] parent;
    int[] size;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x), rootY = find(y);

        if (rootX == rootY) return;

        if (size[rootX] < size[rootY]){
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public int getSize(int x){
        return size[find(x)];
    }
}

public class MaximumNumberOfPointsFromGridQueries_2503 {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        int total = n * m;

        int[][] cells = new int[total][3];
        int idx = 0;
        for (int i = 0; i< n; i++){
            for (int j = 0; j < m; j++){
                cells[idx++] = new int[]{grid[i][j], i, j};
            }
        }
        Arrays.sort(cells, Comparator.comparing(a -> a[0]));

        int qLen = queries.length;
        int[][] queriesWithIndex = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            queriesWithIndex[i][0] = queries[i]; // query value
            queriesWithIndex[i][1] = i;          // original index
        }
        Arrays.sort(queriesWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(total);
        boolean[] added = new boolean[total];
        int[] res = new int[qLen];
        int cellInd = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < qLen; i++) {
            int queryValue = queriesWithIndex[i][0];
            // Activate all cells with grid value less than the current query value.
            while (cellInd < total && cells[cellInd][0] < queryValue) {
                int r = cells[cellInd][1], c = cells[cellInd][2];
                int pos = r * m + c;
                added[pos] = true;
                // Union with already activated neighbors.
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    int neighborPos = nr * m + nc;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && added[neighborPos]) {
                        uf.union(pos, neighborPos);
                    }
                }
                cellInd++;
            }
            if (added[0]) {
                res[queriesWithIndex[i][1]] = uf.getSize(0);
            } else {
                res[queriesWithIndex[i][1]] = 0;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        MaximumNumberOfPointsFromGridQueries_2503 m = new MaximumNumberOfPointsFromGridQueries_2503();
        m.maxPoints(new int[][]{{1,2,3},{2,5,7},{3,5,1}}, new int[]{5,6,2});
        //m.maxPoints(new int[][]{{5,2,1},{1,1,2}}, new int[]{3});
    }
}
