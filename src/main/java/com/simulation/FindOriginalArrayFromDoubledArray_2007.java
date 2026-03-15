package com.simulation;

import java.util.*;

public class FindOriginalArrayFromDoubledArray_2007 {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        Arrays.sort(changed);
        Map<Integer, Integer> fre = new HashMap<>();
        for (int c : changed) {
            fre.put(c, fre.getOrDefault(c, 0) + 1);
        }

        int[] res = new int[changed.length / 2];
        int i = 0;

        for (int num : changed) {
            if (fre.get(num) == 0) continue;

            if (fre.getOrDefault(num * 2, 0) == 0) return new int[0];

            res[i++] = num;
            fre.put(num, fre.get(num) - 1);
            fre.put(num * 2, fre.get(num * 2) - 1);
        }

        return i == changed.length / 2 ? res : new int[0];
    }

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray_2007 f= new FindOriginalArrayFromDoubledArray_2007();
        f.findOriginalArray(new int[]{0,0,0,0});
    }
}
