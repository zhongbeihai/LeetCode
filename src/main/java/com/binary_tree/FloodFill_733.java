package com.binary_tree;

import structure.Pair;

import java.util.ArrayDeque;

public class FloodFill_733 {
    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        bfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public int[][] dfs(int[][] image, int sr, int sc, int preC, int color){
        image[sr][sc] = color;
        for(int[] direction: directions){
            int row = sr + direction[0];
            int col = sc + direction[1];
            if(row >=0 && row < image.length &&
                    col >= 0 && col < image[0].length &&
                    image[row][col] == preC){
                dfs(image, row, col, preC, color);
            }
        }
        return image;
    }

    public int[][] bfs(int[][] image, int sr, int sc, int preC, int color){
        ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(sr, sc));
        while (!deque.isEmpty()){
            Pair<Integer, Integer> p = deque.pop();
            int r = p.getKey();
            int c = p.getValue();
            image[r][c] = color;
            for(int[] direction: directions){
                int row = r + direction[0];
                int col = c + direction[1];
                if(row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == preC){
                    deque.add(new Pair<>(row, col));
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFill_733 f = new FloodFill_733();
        f.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
    }
}
