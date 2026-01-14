package com.dynamic_programming;

import structure.Pair;

import java.util.*;

public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Pair<Integer, Integer>> map = new HashMap<>();
        char[] ss = s.toCharArray();
        int count = 0;
        for(char c: ss){
            count++;
            if(map.get(c) == null){
                map.put(c, new Pair<>(count, count));
            }else {
                Pair<Integer, Integer> p = map.get(c);
                map.put(c, new Pair<>(p.getKey(), count));
            }
        }

        int[][] intervals = new int[map.size()][2];
        count = map.size() - 1;
        for(Pair<Integer, Integer> p: map.values()){
            intervals[count][0] = p.getKey();
            intervals[count][1] = p.getValue();
            count--;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<Integer> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < map.size(); i++){
            if(intervals[i][0] < right && intervals[i][1] > right){
                right = intervals[i][1];
            }
            if(intervals[i][0] > right){
                res.add(right - left + 1);
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(right - left + 1);
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels_763 p = new PartitionLabels_763();
        p.partitionLabels("ababcbacadefegdehijhklij");
    }
}
