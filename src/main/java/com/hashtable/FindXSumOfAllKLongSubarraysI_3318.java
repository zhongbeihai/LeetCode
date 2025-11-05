package com.hashtable;

import java.util.*;

public class FindXSumOfAllKLongSubarraysI_3318 {
    public int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        for (int i = 0; i < k; i++){
            fre.put(nums[i], fre.getOrDefault(nums[i], 0) + 1);
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++){
            res[i] = computer(fre, x);
            fre.put(nums[i], fre.get(nums[i]) - 1);
            if (i + k < nums.length) fre.put(nums[i + k], fre.getOrDefault(nums[i + k], 0) + 1);
        }

        return res;
    }

    public int computer(HashMap<Integer, Integer> fre, int x){
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e: fre.entrySet()){
            list.add(new int[]{e.getKey(), e.getValue()});
        }

        int r = 0;
        if (fre.size() < x) {
            for (int[] c: list) r += c[0] * c[1];
            return r;
        }

        Collections.sort(list, (i , j) -> {
            if (i[1] == j[1]) {
                return j[0] - i[0];
            }else {
                return j[1] - i[1];
            }
        });


        for (int i = 0; i < x; i++){
            int[] c = list.get(i);
            r += c[0] * c[1];
        }

        return r;
    }

    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysI_3318 f = new FindXSumOfAllKLongSubarraysI_3318();
        //f.findXSum(new int[]{3,8,7,8,7,5}, 2, 2);
        f.findXSum(new int[]{9,2,2},3,3);
    }
}
