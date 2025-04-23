package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
       int[][] dp = new int[triangle.size()][triangle.size()];
       dp[0][0] = triangle.get(0).get(0);
       for(int i = 1; i < triangle.size(); i++){
           for(int j = 0; j < triangle.get(i).size(); j++){
               if(j == triangle.get(i - 1).size()){
                   dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
               }else {
                   dp[i][j] = Math.min(dp[i - 1][j], j >= 1?dp[i - 1][j - 1]:dp[i-1][0]) + triangle.get(i).get(j);
               }

           }
       }
       return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        Triangle_120 t = new Triangle_120();
        int[][] arr = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        ArrayList<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++){
                a.add(arr[i][j]);
            }
            l.add(a);
        }
        t.minimumTotal(l);
    }
}
