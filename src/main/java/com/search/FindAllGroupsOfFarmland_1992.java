package com.search;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland_1992 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] findFarmland(int[][] land) {
        ArrayList<List<Integer>> rr = new ArrayList<>();
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 0) continue;
                if(land[i][j] == 1) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    int[] rightDown = dfs(land, i, j);
                    l.add(rightDown[0]);
                    l.add(rightDown[1]);
                    rr.add(l);
                }
            }
        }
        int[][] ans = new int[rr.size()][4];
        for(int i = 0; i < rr.size(); i++){
            for(int j = 0; j < rr.get(i).size(); j++){
                ans[i][j] = rr.get(i).get(j);
            }
        }
        return ans;
    }

    public int[] dfs(int[][] land, int x, int y){
        int[] r = new int[2];
        land[x][y] = 2;
        r[0] = x;
        r[1] = y;
        for(int[] direction : directions){
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < land.length && newY >=0 && newY < land[0].length
            && land[newX][newY] == 1){
                r[0] = newX;
                r[1] = newY;
                int[] rr = dfs(land, newX, newY);
                r[0]= Math.max(r[0], rr[0]);
                r[1] = Math.max(r[1], rr[1]);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        FindAllGroupsOfFarmland_1992 f = new FindAllGroupsOfFarmland_1992();
        f.findFarmland(new int[][]{ {0,1,},{1,0,}});
    }
}
