package com.dequeue_and_priorityqueue;

import java.util.*;
import java.util.stream.Collectors;

public class LuckyNumbersInMatrix_1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rows = new int[matrix.length];
        Arrays.fill(rows, Integer.MAX_VALUE);
        int[] cols = new int[matrix[0].length];
        Arrays.fill(cols,Integer.MIN_VALUE);
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < rows[i]) {rows[i] = matrix[i][j];}
                if(matrix[i][j] > cols[j]) {cols[j] = matrix[i][j];}
            }
        }
        Set<Integer> rowSet = Arrays.stream(rows).boxed().collect(Collectors.toSet());
        Set<Integer> colSet = Arrays.stream(cols).boxed().collect(Collectors.toSet());
        rowSet.retainAll(colSet);
        ArrayList<Integer> res = new ArrayList<Integer>(rowSet);
        return res;

    }

    public static void main(String[] args) {
        LuckyNumbersInMatrix_1380 l = new LuckyNumbersInMatrix_1380();
        l.luckyNumbers(new int[][]{{7,8},{1,2}});
    }
}
