package com.backtrack;

import java.util.*;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */
public class CombinationSum_39 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] candidates, int rest, int startIdx, List<Integer> tem){
        // termination conditions
        if (rest == 0){
            res.add(new ArrayList<>(tem));
            return;
        }
        if (rest < 0) return;

        for (int i = startIdx; i < candidates.length; i++){
            if (candidates[i] > rest) break;
            if (i > 0 && candidates[i] == candidates[i - 1]) continue;

            tem.add(candidates[i]);
            backtrack(candidates, rest - candidates[i], i, tem);
            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 c = new CombinationSum_39();
        c.combinationSum(new int[]{2,3,6,7}, 7);
    }
}
