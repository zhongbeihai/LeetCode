package com.search;

import structure.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class VerticalOrderTraversalOfBinaryTree_987 {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (int col : map.keySet()) {
            List<Integer> cur = new ArrayList<>();
            for (int row : map.get(col).keySet()) {
                PriorityQueue<Integer> pq = map.get(col).get(row);
                while (!pq.isEmpty()) {
                    cur.add(pq.poll());
                }
            }
            res.add(cur);
        }
        return res;
    }

    public void dfs(TreeNode root, int row, int col) {
        if (root == null) return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(root.val);

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}
