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
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, 0);

        return res;
    }

    public void backtrack(int[] candidates, int target, List<Integer> tem, int curSum, int start){
        if (curSum >= target){
            if (curSum == target) res.add(new ArrayList<>(tem));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tem.add(candidates[i]);

            backtrack(candidates, target, tem, curSum + candidates[i], i);

            tem.remove(tem.size() - 1);
        }
    }

    public static List<List<Integer>> mergeSimilarLists(List<List<Integer>> listOfLists) {
        Map<List<Integer>, List<Integer>> map = new HashMap<>();

        for (List<Integer> list : listOfLists) {
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            map.putIfAbsent(sortedList, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        CombinationSum_39 c = new CombinationSum_39();
        c.combinationSum(new int[]{2,3,6,7}, 7);
    }
}
