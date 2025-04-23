package com.backtrack;

import java.util.*;

public class PermutationsII_47 {
    private Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backTracking(nums, used, 0, new ArrayList<>());
        ArrayList<List<Integer>> resL = new ArrayList<>();
        resL.addAll(res);
        return resL;
    }

    public void backTracking(int[] nums, boolean[] used, int index, List<Integer> tem){
        if(index == nums.length){
            res.add(new ArrayList<>(tem));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }

            tem.add(nums[i]);
            used[i] = true;

            backTracking(nums, used, index + 1, tem);

            tem.remove(tem.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII_47 p = new PermutationsII_47();
        System.out.println(p.permuteUnique(new int[]{1,1,2,2}));
    }
}
