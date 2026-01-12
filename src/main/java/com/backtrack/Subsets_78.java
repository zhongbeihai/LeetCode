package com.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets_78 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, int idx, List<Integer> tem){
        res.add(new ArrayList<>(tem));
        if (tem.size() == nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            tem.add(nums[i]);

            backtrack(nums, i + 1, tem);

            tem.remove(tem.size() - 1);
        }
    }



    public static void main(String[] args) {
        Subsets_78 s = new Subsets_78();
        s.subsets(new int[]{1,2,3});
    }
}
