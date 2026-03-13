package com.simulation;

import java.util.*;

public class FindOriginalArrayFromDoubledArray_2007 {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> fre = new HashMap<>();
        for (int c : changed){
            fre.put(c, fre.getOrDefault(c, 0) + 1);
        }

        int[] res = new int[changed.length / 2];
        int i = 0;
        for (int num: fre.keySet()){
            if (fre.get(num) == 0) continue;

            if (num == 0){
                if (fre.get(num) < 2) return new int[0];
                fre.put(num, fre.getOrDefault(num, 0) - 2);
            }else {
                if (fre.getOrDefault(num * 2, 0) < fre.get(num)) return new int[0];
                fre.put(num, fre.get(num) - 1);
                fre.put(num * 2, fre.get(num * 2) - 1);
            }
            res[i++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray_2007 f= new FindOriginalArrayFromDoubledArray_2007();
        f.findOriginalArray(new int[]{0,0,0,0});
    }
}
