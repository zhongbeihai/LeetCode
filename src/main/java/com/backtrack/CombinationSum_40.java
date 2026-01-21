package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be **used once** in the combination.
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class CombinationSum_40 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    public void backTracking(int[] candidates, int rest, List<Integer> tem, int start){
       if (rest == 0) {
           res.add(new ArrayList<>(tem));
           return;
       }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (rest - candidates[i] >= 0) {
                tem.add(candidates[i]);

                backTracking(candidates, rest - candidates[i], tem, i + 1);

                tem.remove(tem.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum_40 c = new CombinationSum_40();
        c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
