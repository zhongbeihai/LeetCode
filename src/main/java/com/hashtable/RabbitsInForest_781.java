package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RabbitsInForest_781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> set = new HashMap<>();

        int res = 0;
        for (int answer: answers){
            if (answer == 0) {
                res++;
                continue;
            }
            set.put(answer, set.getOrDefault(answer, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> e: set.entrySet()){
            if (e.getKey() > e.getValue()) res += e.getKey() + 1;
            else res += (int) Math.ceil((double) e.getValue() / (e.getKey() + 1)) * (e.getKey() + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        RabbitsInForest_781 r = new RabbitsInForest_781();
        r.numRabbits(new int[]{0,0,1,1,1});
    }
}
