package com.binary_tree;

import javafx.util.Pair;
import structure.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {
    private TreeMap<Integer, List<Integer>> map = new TreeMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root);
        for (Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            ans.add(e.getValue());
        }


        return ans;
    }

    public void bfs(TreeNode root){
        if (root == null) return;

        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> cur = queue.poll();
            TreeNode node = cur.getKey();
            int col = cur.getValue();
            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) queue.add(new Pair<>(node.left, col- 1));
            if (node.right != null) queue.add(new Pair<>(node.right, col + 1));
        }
    }
}
