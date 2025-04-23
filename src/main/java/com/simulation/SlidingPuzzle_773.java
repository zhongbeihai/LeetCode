package com.simulation;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class SlidingPuzzle_773 {
    public int slidingPuzzle(int[][] board) {
        HashSet<String> set = new HashSet<>();
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                start.append(ints[j]);
            }
        }

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        ArrayDeque<Pair<StringBuilder, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(start, 0));
        while (!deque.isEmpty()){
            Pair<StringBuilder, Integer> cur = deque.pop();
            StringBuilder curString = cur.getKey();
            if(curString.toString().equals(target)) return cur.getValue();
            int zeroInd = curString.indexOf("0");
            int x = (zeroInd) / 3;
            int y = (zeroInd) % 3;
            for(int[] dir: dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                int nInd = nx * 3 + ny;
                if(nx >= 0 && nx < 2 && ny >= 0 && ny < 3){
                    char tem = curString.charAt(nInd);
                    StringBuilder nString = new StringBuilder(curString);
                    nString.setCharAt(nInd, '0');
                    nString.setCharAt(zeroInd, tem);
                    if(set.contains(nString.toString())) continue;
                    set.add(nString.toString());
                    deque.add(new Pair<>(nString, cur.getValue() + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SlidingPuzzle_773 s = new SlidingPuzzle_773();
        // s.slidingPuzzle(new int[][]{{4,1,2},{5,0,3}});
        s.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}});
    }
}
