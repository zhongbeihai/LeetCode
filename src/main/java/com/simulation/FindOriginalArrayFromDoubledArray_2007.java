package com.simulation;

import java.util.*;

public class FindOriginalArrayFromDoubledArray_2007 {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> fre = new HashMap<>();
        for (int c: changed) fre.put(c, fre.getOrDefault(c, 0) + 1);

        int[] res = new int[changed.length / 2];
        int j = 0;
        Arrays.sort(changed);
        if (fre.containsKey(0)){
            if (fre.get(0) % 2 == 1) return new int[0];
        }
        for (int c: changed){
            int curFre = fre.get(c);
            if (curFre == 0) continue;
            if (!fre.containsKey(c * 2) || fre.get(c * 2) < curFre) return new int[0];

            res[j++] = c;
            if (c == 0){
                fre.put(c, fre.get(c) - 2);
            }else {
                fre.put(c, fre.get(c) - 1);
                fre.put(c * 2, fre.get(c * 2) - 1);
            }

        }

        return j == changed.length / 2 ? res : new int[0];
    }

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray_2007 f= new FindOriginalArrayFromDoubledArray_2007();
        f.findOriginalArray(new int[]{0,0,0,0});
    }
}
