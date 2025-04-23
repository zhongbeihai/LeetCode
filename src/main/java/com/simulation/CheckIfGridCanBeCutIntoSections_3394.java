package com.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CheckIfGridCanBeCutIntoSections_3394 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] x = new int[rectangles.length][2];
        int[][] y = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; i++){
            int[] rec = rectangles[i];
            x[i] = new int[]{rec[0], rec[2]};
            y[i] = new int[]{rec[1], rec[3]};
        }

        Arrays.sort(x, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(y, Comparator.comparingInt(a -> a[0]));

        int maxEnd = y[0][1], sections = 0;
        for (int i = 1; i < rectangles.length; i++){
            int cs = y[i][0], ce = y[i][1];
            if (cs >= maxEnd) sections++;
            maxEnd = Math.max(maxEnd, ce);
        }
        if (sections >= 2) return true;

        maxEnd = x[0][1];
        sections = 0;
        for (int i = 1; i < rectangles.length; i++){
            int cs = x[i][0], ce = x[i][1];
            if (cs >= maxEnd) sections++;
            maxEnd = Math.max(maxEnd, ce);
        }
        if (sections >= 2) return true;

        return false;
    }

    public static void main(String[] args) {
        CheckIfGridCanBeCutIntoSections_3394 c = new CheckIfGridCanBeCutIntoSections_3394();
        // c.checkValidCuts(5, new int[][]{{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}});
        // c.checkValidCuts(4, new int[][]{{0,0,1,1},{2,0,3,4},{0,2,2,3},{3,0,4,3}});
        // c.checkValidCuts(3, new int[][]{{0,0,1,2},{1,0,2,2},{1,2,3,3},{2,0,3,2},{0,2,1,3}});
        c.checkValidCuts(4, new int[][]{{0,0,1,4},{1,0,2,4},{2,0,3,4},{3,0,4,4}});
    }
}
