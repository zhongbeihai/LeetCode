package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * return the answer in any order.
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations_46 {
    private List<List<Integer>> anw = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backTracking(nums, new LinkedList<>(), 0);
        return anw;
    }

    public void backTracking(int[] nums, List<Integer> res, int index ){
        if(res.size() == nums.length){
            anw.add(new ArrayList<>(res));
            return;
        }

        for(int i = index; i < nums.length; i++){
            res.add(nums[i]);
            backTracking(nums, res, i + 1);
            res.remove(Integer.valueOf(nums[i]));
        }
    }

    public static void main(String[] args) {
        Permutations_46 p = new Permutations_46();
        p.permute(new int[]{1,2,3});

    }
}
