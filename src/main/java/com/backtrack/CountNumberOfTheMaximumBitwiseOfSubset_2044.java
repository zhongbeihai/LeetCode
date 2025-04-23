package com.backtrack;

import java.util.*;

public class CountNumberOfTheMaximumBitwiseOfSubset_2044 {
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public int countMaxOrSubsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return map.lastEntry().getValue();
    }

    public void backtracking(int[] nums, int start, List<Integer> tem){

        for(int i = start; i < nums.length; i++){
            tem.add(nums[i]);
            int bitwiseOr = 0;
            for(int j: tem){
                bitwiseOr |= j;
            }
            map.put(bitwiseOr, map.getOrDefault(bitwiseOr, 0) + 1);

            backtracking(nums, i + 1, tem);

            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        CountNumberOfTheMaximumBitwiseOfSubset_2044 c = new CountNumberOfTheMaximumBitwiseOfSubset_2044();
        c.countMaxOrSubsets(new int[]{3,2,1,5});
    }
}
