package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII_90 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0 , new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> tem){
        // return condition
        res.add(new ArrayList<>(tem));
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            tem.add(nums[i]);
            backtrack(nums, i + 1, tem);
            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetII_90 s = new SubsetII_90();
        s.subsetsWithDup(new int[]{1,2,2});
    }
}
