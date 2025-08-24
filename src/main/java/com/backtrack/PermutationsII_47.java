package com.backtrack;

import java.util.*;

public class PermutationsII_47 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums, new boolean[nums.length], new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> tem){
        if (tem.size() == nums.length){
            res.add(new ArrayList<>(tem));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!used[i]){
                tem.add(nums[i]);
                used[i] = true;
                backtrack(nums, used,  tem);
                used[i] = false;
                tem.remove(tem.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII_47 p = new PermutationsII_47();
        System.out.println(p.permuteUnique(new int[]{1,1,2,2}));
    }
}
