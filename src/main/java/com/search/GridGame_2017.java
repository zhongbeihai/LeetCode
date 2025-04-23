package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class GridGame_2017 {

    public long gridGame(int[][] grid) {
        int up = Arrays.stream(grid[0]).sum(), bottom = 0;
        long res = Long.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++){
            up -= grid[0][i];
            res = Math.min(res, Math.max(up, bottom));
            bottom += grid[1][i];
        }

        return res;
    }



    public static void main(String[] args) {
        GridGame_2017 g = new GridGame_2017();
        g.gridGame(new int[][]{{2,5,4},{1,5,1}});
    }
}
