package com.search;

public class CountUnguardedCellsInTheGrid_2257 {
    int[][] space;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        space = new int[m][n];
        for(int[] wall: walls){
            space[wall[0]][wall[1]] = 2;
        }
        for(int[] guard: guards){
            space[guard[0]][guard[1]] = 2;
        }

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] guard: guards){
            for(int[] dir: directions){

                dfs(guard[0], guard[1], dir);
            }
        }

        int count = 0;
        for(int[] ss: space){
            for(int s: ss ){
                if (s == 0) count++;
            }
        }

        return count;
    }

    public void dfs(int startX, int startY, int[] direct){

        startX = startX + direct[0];
        startY = startY + direct[1];
        if(startX < space.length && startY < space[0].length && startX >= 0 && startY >= 0
        && space[startX][startY] != 2){
            space[startX][startY] = 1;
            dfs(startX, startY, direct);
        }

        return;
    }

    public static void main(String[] args) {
        CountUnguardedCellsInTheGrid_2257 c = new CountUnguardedCellsInTheGrid_2257();
        c.countUnguarded(4,6, new int[][]{{0,0},{1,1},{2,3}}, new int[][]{{0,1},{2,2},{1,4}});
    }
}
