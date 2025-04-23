package com.sliding_windows;

import java.util.HashMap;

public class DistinctNumberInEachSubarray_1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int p1 = 0, p2 = 0;
        while (p2 - p1 < k ){
            map.put(nums[p2], map.getOrDefault(nums[p2], 0) + 1);
            p2++;
        }
        int[] res = new int[nums.length - k + 1];
        res[p1] = map.keySet().size();

        while (p2 < nums.length){
            map.put(nums[p2], map.getOrDefault(nums[p2], 0) + 1);
            p2++;
            map.put(nums[p1], map.get(nums[p1]) - 1);
            if (map.get(nums[p1]) == 0) map.remove(nums[p1]);
            p1++;
            res[p1] = map.keySet().size();
        }

        return res;
    }

    public static void main(String[] args) {
        DistinctNumberInEachSubarray_1852 d = new DistinctNumberInEachSubarray_1852();
        d.distinctNumbers(new int[]{1,2,3,2,2,1,3}, 3);
    }
}
