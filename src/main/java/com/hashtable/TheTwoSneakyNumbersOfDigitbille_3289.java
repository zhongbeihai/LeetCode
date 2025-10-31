package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TheTwoSneakyNumbersOfDigitbille_3289 {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int[] res = new int[2];

        int i = 0;
        for (int num: nums){
            if (!set.add(num)) res[i++] = num;
        }

        return res;
    }
}
