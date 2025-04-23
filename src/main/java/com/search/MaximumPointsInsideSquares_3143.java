package com.search;

import java.util.Arrays;
import java.util.HashMap;

public class MaximumPointsInsideSquares_3143 {
    private int[][] points;
    private String s;
    private HashMap<int[], Character> map = new HashMap<>();
    public int maxPointsInsideSquare(int[][] points, String s) {
        this.points = points;
        this.s = s;
        for(int i = 0; i < points.length; i++){
            map.put(points[i], s.charAt(i));
        }
        Arrays.sort(points, (p1, p2) ->
                (int) (Math.pow(Math.max(Math.abs(p1[0]), Math.abs(p1[1])), 2) - (int) (Math.pow(Math.max(Math.abs(p2[0]), Math.abs(p2[1])), 2))));

        int l = 0, r = points.length;
        while (l < r - 1){
            int mid = (l + r) / 2;
            if(check(mid)){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;

    }

    public boolean check(int mid){
        HashMap<Character, Integer> labelCount = new HashMap<>();
        for(int i = 0; i <= mid; i++){
            char c = map.get(points[i]);
            labelCount.put(c, labelCount.getOrDefault(c, 0) + 1);
            if(labelCount.get(c) > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumPointsInsideSquares_3143 m = new MaximumPointsInsideSquares_3143();
        // m.maxPointsInsideSquare(new int[][]{{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}}, "abdca");
        // m.maxPointsInsideSquare(new int[][]{{-1,-4},{16,-8},{13,-3},{-12,0}}, "abda");
    }
}
