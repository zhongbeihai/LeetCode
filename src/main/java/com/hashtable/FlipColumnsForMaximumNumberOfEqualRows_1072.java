package com.hashtable;

import java.util.Arrays;

public class FlipColumnsForMaximumNumberOfEqualRows_1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = 1;
        for(int[] row: matrix){
            int[] mrow = Arrays.stream(row).map(i -> i == 0 ? 1 : 0).toArray();
            int ec = 0, mc = 0;
            for(int[] r: matrix){
                if(Arrays.equals(row, r)) ec++;
                if(Arrays.equals(mrow, r)) mc++;
            }
            m = Math.max(m, ec + mc);
        }

        return m;
    }

    public static void main(String[] args) {
        FlipColumnsForMaximumNumberOfEqualRows_1072 f = new FlipColumnsForMaximumNumberOfEqualRows_1072();
        f.maxEqualRowsAfterFlips(new int[][]{{0,0,0},{0,0,1},{1,1,0}});
    }
}
