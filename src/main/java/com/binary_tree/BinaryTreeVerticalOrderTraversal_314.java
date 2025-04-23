package com.binary_tree;

import javafx.util.Pair;
import structure.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {
    private TreeMap<Integer,List<Integer>> map = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        bfs(root);

        List<List<Integer>> res = new ArrayList<>();
        for (Integer i: map.keySet()){
            res.add(map.get(i));
        }
        return res;
    }

    public void bfs(TreeNode root){
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int pos = p.getValue();
            if (map.get(pos) == null){
                List<Integer> l = new ArrayList<>();
                l.add(node.val);
                map.put(pos, l);
            }else {
                map.get(pos).add(node.val);
            }

            if (node.left != null) queue.add(new Pair<>(node.left, pos - 1));
            if (node.right != null) queue.add(new Pair<>(node.right, pos + 1));
        }
    }
    public void dfs(TreeNode root, int pos){
        if (root == null) return;

        dfs(root.left, pos - 1);
        dfs(root.right, pos + 1);
        if (map.get(pos) == null){
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            map.put(pos, l);
        }else {
            map.get(pos).add(root.val);
        }
    }
}
