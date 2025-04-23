package com.hashtable;

import java.util.HashMap;

public class FindThePrefixCommonArrayOfTwoArray_2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[A.length + 1];
        int common = 0;
        int[] res = new int[A.length + 1];
        for(int i = 0; i < A.length; i++){
            if(++freq[A[i]] == 2) common++;
            if(++freq[B[i]] == 2) common++;
            res[i] = common;
        }

        return res;
    }
}
