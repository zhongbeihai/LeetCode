package com.dynamic_programming;

import java.util.*;

public class NonDecreasingSubsequences_491 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        Map<Integer, List<List<Integer>>> memo = new HashMap<>();
        List<Integer> init = Arrays.asList(nums[0]);
        memo.computeIfAbsent(0, v -> new ArrayList<>()).add(init);

        for (int i = 1; i < nums.length; i++) {
            List<Integer> s = new ArrayList<>();
            s.add(nums[i]);
            List<List<Integer>> endAtI = new ArrayList<>();
            endAtI.add(s);
            memo.put(i, endAtI);
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    for(List<Integer> endAtJ: memo.get(j)){
                        List<Integer> tem = new ArrayList<>(endAtJ);
                        tem.add(nums[i]);
                        endAtI.add(tem);
                    }
                }
            }
        }

        memo.remove(0);
        Set<List<Integer>> res = new HashSet<>();
        for (List<List<Integer>> v: memo.values()){
            for (List<Integer> l: v){
                if (l.size() > 1) res.add(l);
            }
        }

        return new ArrayList<>(res);
    }
}
