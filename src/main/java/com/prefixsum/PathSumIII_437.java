package com.prefixsum;

import structure.TreeNode;

import java.util.HashMap;

public class PathSumIII_437 {

    public int pathSum(TreeNode root, int targetSum) {
        // <prefixSum, freq>
        HashMap<Long, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0l, 1);

        count = get(root, map, targetSum, 0L);
        return count;
    }

    private int get(TreeNode root, HashMap<Long, Integer> map ,int targetSum, Long preSum){
        if(root == null){
            return 0;
        }

        int count = 0;
        preSum += root.val;
        if(map.containsKey(preSum - targetSum))
            count += map.get(preSum - targetSum);

        map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        count += get(root.left, map, targetSum, preSum);
        count += get(root.right, map, targetSum, preSum);

        map.put(preSum, map.get(preSum) - 1);

        return count;
    }
}
