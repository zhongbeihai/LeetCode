package com.dynamic_programming;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestFibonacciSubsuquence_873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        int res = 0;
        for (int i = 0; i < n; i++){

            for (int j = i + 1; j < n; j++){
                int count = 2;
                int prev = arr[j], prevv = arr[i];
                while (map.containsKey(prev + prevv)){
                    count++;
                    int tem = prev;
                    prev = prev + prevv;
                    prevv = tem;
                }
                res = Math.max(res, count);
            }
        }

        return res == 2 ? 0 : res;
    }

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsuquence_873 l = new LengthOfLongestFibonacciSubsuquence_873();
        l.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18});
    }

}
