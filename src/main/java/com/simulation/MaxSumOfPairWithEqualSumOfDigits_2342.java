package com.simulation;

import java.util.*;

public class MaxSumOfPairWithEqualSumOfDigits_2342 {
    public int maximumSum(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num: nums){
            int sum = digitsSum(num);
            if (map.get(sum) == null){
                List<Integer> l = new ArrayList<>();
                l.add(num);
                map.put(sum ,l);
            }else {
                map.get(sum).add(num);
            }
        }

        int res = -1;
        for (List<Integer> list: map.values()){
            if (list.size() < 2) continue;
            Collections.sort(list, Collections.reverseOrder());
            res = Math.max(res, list.get(0) + list.get(1));
        }

        return res;
    }

    public int digitsSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
