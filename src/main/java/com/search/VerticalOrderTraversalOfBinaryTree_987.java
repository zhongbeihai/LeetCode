package com.search;

import structure.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class VerticalOrderTraversalOfBinaryTree_987 {
    private Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); // <col, <level, Que>>
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (Integer col: map.keySet()){
            List<Integer> colList = new ArrayList<>();
            Map<Integer, PriorityQueue<Integer>> colMap = map.get(col);
            for (Integer row: map.get(col).keySet()){
                PriorityQueue<Integer> pq = colMap.get(row);
                while (!pq.isEmpty()){
                    colList.add(pq.poll());
                }
            }

            res.add(colList);
        }

        return res;
    }

    public void dfs(TreeNode root, int col, int level){
        if (root == null) return;

        map.computeIfAbsent(col, v -> new TreeMap<>())
                .computeIfAbsent(level, v -> new PriorityQueue<>()).add(root.val);

        dfs(root.left, col - 1, level + 1); // to left child
        dfs(root.right, col + 1, level + 1); // to right child;
    }
}
