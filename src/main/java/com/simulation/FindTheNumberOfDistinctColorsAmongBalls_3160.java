package com.simulation;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindTheNumberOfDistinctColorsAmongBalls_3160 {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorsUsed = new HashMap<>();
        int[] res = new int[queries.length];
        HashMap<Integer, Integer> ballColors = new HashMap<>();
        for (int i = 0; i < queries.length; i++){
            int ball = queries[i][0], color = queries[i][1];
            if (ballColors.get(ball) == null) {
                colorsUsed.put(color, colorsUsed.getOrDefault(color, 0) + 1);
            } else if (ballColors.get(ball) != color) {
                int prevColor = ballColors.get(ball);
                colorsUsed.put(prevColor, colorsUsed.get(prevColor) - 1);
                if (colorsUsed.get(prevColor) == 0)
                    colorsUsed.remove(prevColor);
                colorsUsed.put(color, colorsUsed.getOrDefault(color, 0) + 1);

            }
            ballColors.put(ball, color);
            res[i] = colorsUsed.keySet().size();
        }

        return res;
    }

    public static void main(String[] args) {
        FindTheNumberOfDistinctColorsAmongBalls_3160 f = new FindTheNumberOfDistinctColorsAmongBalls_3160();
        f.queryResults(1, new int[][]{{0,1},{0,4},{0,4},{0,1},{1,2}});
    }
}
