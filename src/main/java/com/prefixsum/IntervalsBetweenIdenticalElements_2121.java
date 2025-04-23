package com.prefixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntervalsBetweenIdenticalElements_2121 {
    public long[] getDistances(int[] arr){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        long[] res = new long[arr.length];
        for(List<Integer> l : map.values()){
            int size = l.size();
            long[] preSum = new long[size + 1];
            for(int i = 0; i < size; i++){
                preSum[i + 1] = preSum[i] + l.get(i);
            }

            for(int i = 0; i < size; i++){
                int currentIdx = l.get(i);
                long leftSum = (long)i * currentIdx - preSum[i];
                long rightSum = (preSum[size] - preSum[i + 1]) - (long)(size - i - 1) * currentIdx;
                res[currentIdx] = leftSum + rightSum;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        IntervalsBetweenIdenticalElements_2121 i = new IntervalsBetweenIdenticalElements_2121();
        i.getDistances(new int[]{2,1,3,1,2,3,3});
    }
}
