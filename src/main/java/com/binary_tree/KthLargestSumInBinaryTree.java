package com.binary_tree;

import structure.Pair;
import structure.TreeNode;


import java.util.*;

public class KthLargestSumInBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        TreeMap<Integer, Long> map = new TreeMap<>();
        q.add(new Pair<>(root, 0));
        while (!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();
            map.put(p.getValue(), map.getOrDefault(p.getValue(), 0L) + p.getKey().val);
            if (p.getKey().left != null) q.add(new Pair<>(p.getKey().left, p.getValue() + 1));
            if (p.getKey().right != null) q.add(new Pair<>(p.getKey().right, p.getValue() + 1));
        }

        if(map.lastKey() < k - 1) return -1;
        ArrayList<Long> a = new ArrayList<>();
        for(Map.Entry<Integer, Long> set: map.entrySet()){
            a.add(set.getValue());
        }
        a.sort(Collections.reverseOrder());
        return a.get(k - 1);
    }
}
