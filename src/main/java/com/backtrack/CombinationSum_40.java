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
        if (candidates.length == 0) return res;

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] candidates, int rest, int startIdx, List<Integer> tem){
        if (rest == 0) {
            res.add(new ArrayList<>(tem));
            return;
        }
        if (rest < 0) return;

        for (int i =  startIdx; i < candidates.length; i++){
            if (candidates[i] > rest) break;
            if (i > startIdx && candidates[i] == candidates[i - 1]) continue;

            tem.add(candidates[i]);
            backtrack(candidates, rest - candidates[i], i + 1, tem);
            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_40 c = new CombinationSum_40();
        c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
