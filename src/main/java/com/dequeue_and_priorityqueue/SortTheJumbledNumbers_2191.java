package com.dequeue_and_priorityqueue;

import com.hashtable.SortArrayByIncreasingFrequency_1636;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

public class SortTheJumbledNumbers_2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Pair<Integer, Integer>> l = new ArrayList<Pair<Integer, Integer>>();
        for(int num: nums){
            String[] n = String.valueOf(num).split("");
            StringBuilder newNum = new StringBuilder();
            for(int i = 0; i < n.length; i++){
                newNum.append(mapping[Integer.parseInt(n[i])]);
            }
            l.add(new Pair<>(num, Integer.parseInt(newNum.toString())));
        }
        l.sort((o1, o2) -> o1.getValue() - o2.getValue());
        int[] res = new int[l.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = l.get(i).getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        SortTheJumbledNumbers_2191 s = new SortTheJumbledNumbers_2191();
        s.sortJumbled(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123});
    }
}
