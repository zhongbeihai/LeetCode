package com.simulation;

import javax.jws.Oneway;

public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int diagonalDir = 1;
        int n = mat.length, m = mat[0].length, cnt = 0;
        int[] res = new int[n * m];

        int x = 0, y = 0;
        while (cnt < n * m){
            res[cnt++] = mat[x][y];

            if (diagonalDir == 1){
                if (x == 0){
                    y++;
                    diagonalDir *= -1;
                } else if (y == m - 1) {
                    x++;
                    diagonalDir *= -1;
                }else {
                    x += diagonalDir;
                    y += diagonalDir;
                }
            }else {
                if (x == n - 1){
                    y++;
                    diagonalDir *= -1;
                } else if (y == 0) {
                    x++;
                    diagonalDir *= -1;
                }else {
                    x += diagonalDir;
                    y += diagonalDir;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
