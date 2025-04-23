package com.backtrack;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteAndEarn_740 {
    int max = Integer.MIN_VALUE;
    public int deleteAndEarn(int[] nums) {
        return dp(nums);
    }

    public int dp(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        int[] dp = new int[map.size() + 1];
        LinkedList<Integer> list = new LinkedList<>(map.keySet());
        list.addFirst(0);
        dp[0] = 0;
        dp[1] = map.get(list.get(1));
        for(int i = 2; i < dp.length; i++) {
            if(list.get(i) - list.get(i - 1) == 1){
                dp[i] = Math.max(dp[i - 2] + map.get(list.get(i)), dp[i - 1]);
            }else {
                dp[i] = dp[i - 1] + map.get(list.get(i));
            }

        }

        return dp[dp.length - 1];
    }

    public void backtracking(List<Integer> nums, int count){
        if(nums.isEmpty()){
            if(count > max) max = count;
            return;
        }
        for(int i = 0 ; i < nums.size() ; i++){
            int a = nums.get(i);
            List<Integer> preList = new ArrayList<>(nums);
            count += a;
            nums.remove(i);
            nums.removeIf(n -> n.equals(a + 1));
            nums.removeIf(n -> n.equals(a - 1));

            backtracking(nums, count);

            nums = new ArrayList<>(preList);
            count -= a;
        }
    }

    public static void main(String[] args) {
        DeleteAndEarn_740 d = new DeleteAndEarn_740();
        d.deleteAndEarn(new int[]{1,1,1,2,4,5,5,5,6});
    }
}
