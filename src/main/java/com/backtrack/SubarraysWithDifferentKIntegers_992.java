package com.backtrack;

import java.util.*;


public class SubarraysWithDifferentKIntegers_992 {
    public static List<Set<Integer>> res;
    public int subarraysWithKDistinct(int[] nums, int k) {
        res = new ArrayList<>();
        backTrack(nums, k, new HashSet<>(), 0);
        for(Set s: res){
            System.out.println(Arrays.toString(s.toArray()));
        }
        return res.size();
    }

    private void backTrack(int[] nums, int k, Set<Integer> set, int n){
        if (set.size() == k) {
            res.add(set);
            return;
        }

        for(int i = n; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                break;
            }
            backTrack(nums, k, set, i + 1);

            set.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        SubarraysWithDifferentKIntegers_992 s = new SubarraysWithDifferentKIntegers_992();
        int a = s.subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2);
        System.out.println(a);
    }
}
