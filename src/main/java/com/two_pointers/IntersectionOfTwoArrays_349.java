package com.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] map = new int[1001];
        for (int num: nums1){
            map[num]++;
        }

        for (int num:nums2){
            if (map[num] > 0){
                list.add(num);
                map[num]--;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_349 i = new IntersectionOfTwoArrays_349();
        i.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }
}
