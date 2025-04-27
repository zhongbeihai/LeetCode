package com.prefixsum;

import java.util.HashMap;

public class SubarraySumsDivisibleByK_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int curSum = 0, res = 0;
        HashMap<Integer, Integer> fre = new HashMap<>();

        fre.put(0, 1);
        for (int num : nums) {
            curSum += num;
            int rem = curSum % k;
            if (rem < 0) rem += k;
            int need = k - rem;

            if (fre.containsKey(rem)) res += fre.get(rem);
            fre.put(rem, fre.getOrDefault(rem, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleByK_974 s = new SubarraySumsDivisibleByK_974();
        s.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
    }
}
