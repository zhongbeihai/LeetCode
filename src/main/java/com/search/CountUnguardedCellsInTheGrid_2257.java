package com.search;

public class CountUnguardedCellsInTheGrid_2257 {
    int[][] space;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        space = new int[m][n];
        for (int[] wall: walls) space[wall[0]][wall[1]] = 1;
        for (int[] guard: guards) space[guard[0]][guard[1]] = 1;

        for (int[] guard: guards){
            int x = guard[0], y = guard[1];
            goUp(x - 1, y);
            goDown(m, x + 1, y);
            goLeft(x, y - 1);
            goRight(n, x, y + 1);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (space[i][j] == 0) {
                    res++;
                    space[i][j] = 1;
                }
            }
        }

        return res;
    }

    public void goUp( int x, int y){
        while (x >= 0){
            if (space[x][y] == 0) {
                space[x][y] = 1;
                x--;
            }else return;
        }
    }

    public void goDown(int m, int x, int y){
        while (x < m){
            if (space[x][y] == 0) {
                space[x][y] = 1;
                x++;
            }else return;
        }
    }

    public void goLeft(int x, int y){
        while (y >= 0){
            if (space[x][y] == 0) {
                space[x][y] = 1;
                y--;
            }else return;
        }
    }

    public void goRight(int n, int x, int y){
        while (y < n){
            if (space[x][y] == 0) {
                space[x][y] = 1;
                y++;
            }else return;
        }
    }



    public static void main(String[] args) {
        CountUnguardedCellsInTheGrid_2257 c = new CountUnguardedCellsInTheGrid_2257();
        c.countUnguarded(4,6, new int[][]{{0,0},{1,1},{2,3}}, new int[][]{{0,1},{2,2},{1,4}});
    }
}
