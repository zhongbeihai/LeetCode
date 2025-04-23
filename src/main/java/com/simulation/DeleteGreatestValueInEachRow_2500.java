package com.simulation;

import kotlin.DeprecationLevel;

public class DeleteGreatestValueInEachRow_2500 {
    public int deleteGreatestValue(int[][] grid) {
        int cnt = 0;
        int maxOfGrid = 0;
        for(int p = 0; p < grid[0].length; p++){
            for(int i = 0; i < grid.length; i++){
                int maxOfRow = 0;
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] > grid[i][maxOfRow]) maxOfRow = j;
                    if(grid[i][j] > maxOfGrid) maxOfGrid = grid[i][j];
                }
                grid[i][maxOfRow] = 0;
                maxOfRow = 0;
            }
            cnt += maxOfGrid;
            maxOfGrid = -1;
        }
        return cnt;

    }

    public static void main(String[] args) {
        DeleteGreatestValueInEachRow_2500 d = new DeleteGreatestValueInEachRow_2500();
        d.deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}});
    }
}
