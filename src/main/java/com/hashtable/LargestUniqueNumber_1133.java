package com.hashtable;

import java.util.*;

public class LargestUniqueNumber_1133 {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        for (int num: nums){
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(fre.keySet());
        list.sort(Comparator.reverseOrder());
        int res = -1;
        for (int i = 0; i < list.size(); i++){
            if (fre.get(list.get(i)) == 1){
                res = list.get(i);
                break;
            }
        }

        return res;
    }
}
