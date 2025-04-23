package com.sliding_windows;

import java.util.HashMap;
import java.util.HashSet;

public class CountTheNumberOfGoodSubarrays_2537 {
    public long countGood(int[] nums, int k) {
        int left = 0, n = nums.length;
        long count = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> biggerThanK = new HashSet<>();
        int right;
        for (right = 0; right < n; right++){
            int ele = nums[right];
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            if (map.get(ele) >= 2 ){
                count += map.get(ele) - 1;
            }
            if (count >= k) res += n - right;

            while (left < right && count >= k){
                int el = nums[left];
                if (map.get(el) >= 2){
                    count -= map.get(el) - 1;
                }
                map.put(el, map.get(el) - 1);
                if (count >= k) res += n - right;
                left++;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        CountTheNumberOfGoodSubarrays_2537 c = new CountTheNumberOfGoodSubarrays_2537();
        c.countGood(new int[]{3,1,4,3,2,2,4}, 2);
        //c.countGood(new int[]{2,1,3,1,2,2,3,3,2,2,1,1,1,3,1}, 11);
    }
}
