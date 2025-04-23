package com.hashtable;

import java.util.*;

public class SortArrayByIncreasingFrequency_1636 {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if(Objects.equals(o1.getValue(), o2.getValue())){
                return o2.getKey() - o1.getKey();
            }else {
                return o1.getValue() - o2.getValue();
            }
        });

        int[] res = new int[nums.length];
        int c = 0;
        for(Map.Entry<Integer, Integer> entry : list){
            for(int i = 0; i < entry.getValue(); i++){
                res[c] = entry.getKey();
                c++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SortArrayByIncreasingFrequency_1636 s = new SortArrayByIncreasingFrequency_1636();
        s.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
    }
}
