package com.dynamic_programming;

import com.backtrack.ConcatenatedWords_472;

public class CountSquareSubmatricesWithAllOnes_1277 {
    private Integer[][] memo;
    public int countSquares(int[][] matrix) {
        memo = new Integer[matrix.length][matrix.length];
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                count += help(matrix, i ,j);
            }
        }

        return count;
    }

    public int help(int[][] matrix, int x, int y){

        if (matrix[x][y] == 0){
            return 0;
        }
        if(x == matrix.length - 1 || y == matrix[0].length - 1){
            return memo[x][y] = 1;
        }
        if(memo[x][y] != null) return memo[x][y];
        int ri = help(matrix, x , y + 1);
        int bo = help(matrix, x + 1, y);
        int dia = help(matrix, x + 1, y + 1);
        memo[x][y] = Math.min(ri, Math.min(bo, dia)) + 1;
        return ri + bo + dia;
    }

    public static void main(String[] args) {
        CountSquareSubmatricesWithAllOnes_1277 c = new CountSquareSubmatricesWithAllOnes_1277();
        c.countSquares(new int[][]{{0,1,1,1}, {1,1,1,1}, {0,1,1,1}} );
    }
}
