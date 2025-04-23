package com.search;

public class MaximumMovesInAGrid_2684 {
    private Integer[][] memo;
    public int maxMoves(int[][] grid) {
        memo = new Integer[grid.length][grid[0].length];
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++){
            m = Math.max(m, dfs(grid, i, 0));
        }

        return m;
    }

    public int dfs(int[][] grid, int r, int c){
        if (memo[r][c] != null) {
            return memo[r][c];
        } 
        int maxSteps = 0;
        int cur = grid[r][c];

        int[][] dirs = new int[][]{{-1, 1}, {0, 1}, {1, 1}};
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < grid.length && nc < grid.length && grid[nr][nc] > cur){
                maxSteps = Math.max(maxSteps, 1 + dfs(grid, nr, nc));
            }
        }
        memo[r][c] = maxSteps;
        return maxSteps;

    }

    public static void main(String[] args) {
        MaximumMovesInAGrid_2684 m = new MaximumMovesInAGrid_2684();
        m.maxMoves(new int[][]{{3,2,4}, {2,1,9}, {1,1,7}});
    }
}
