package com.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountLargestGroup_1399 {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxSize = 0;
        for (int i = 1; i <= n; i++){
            int sum = getDigitsSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxSize = Math.max(maxSize, map.get(sum));
        }
        int res = 0;
        List<Integer> list = new ArrayList<>(map.values());
        for (int l: list){
            if (l == maxSize) res++;
        }

        return res;
    }

    public int getDigitsSum(int nums){
        if (nums / 10 == 0){
            return nums;
        }

        int sum = getDigitsSum(nums/10);

        return sum + getDigitsSum(nums % 10);
    }

    public static void main(String[] args) {
        CountLargestGroup_1399 c= new CountLargestGroup_1399();
        c.countLargestGroup(13);
    }
}
