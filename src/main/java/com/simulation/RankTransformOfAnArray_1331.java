package com.simulation;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray_1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] cop = new int[arr.length];
        cop = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cop);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int rank = 1;
        for(int i = 0; i < cop.length; i++){
            if(i >= 1 && cop[i] > cop[i - 1]) rank++;
            map.put(cop[i], rank);
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        RankTransformOfAnArray_1331 r = new RankTransformOfAnArray_1331();
        r.arrayRankTransform(new int[]{40,30,10,50,10});
    }
}
