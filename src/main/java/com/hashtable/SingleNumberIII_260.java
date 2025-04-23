package com.hashtable;

import java.util.HashMap;

public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[2];
        int i = 0;
        for(Integer key: map.keySet()){
            if(map.get(key) < 2){
                res[i] = key;
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SingleNumberIII_260 s = new SingleNumberIII_260();
        s.singleNumber(new int[]{1,2,1,3,2,5});
    }
}
