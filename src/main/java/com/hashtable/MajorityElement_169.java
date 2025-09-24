package com.hashtable;

import java.util.HashMap;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mf = 0, me = -1;
        for (int num: nums){
            int f = map.getOrDefault(num, 0) + 1;
            map.put(num, f);
            if (f > mf){
                mf = f;
                me = num;
            }
        }

        return me;
    }
}
