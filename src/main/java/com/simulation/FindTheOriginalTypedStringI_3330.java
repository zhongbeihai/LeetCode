package com.simulation;

public class FindTheOriginalTypedStringI_3330 {
    public int possibleStringCount(String word) {
        char[] cc = word.toCharArray();
        int res = 1;

        for (int i = 1; i < cc.length; i++) {
            if (cc[i] == cc[i - 1]) res++;
        }

        return res;
    }
}
