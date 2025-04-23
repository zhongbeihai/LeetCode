package com.binary_tree;

import javafx.util.Pair;
import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class AmountOfTimeForBinaryTreeToBeInfected_2385 {
    private HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode startNode = null;

    public int amountOfTime(TreeNode root, int start) {
        prepare(root, start);
        return infectTime(startNode);
    }

    public void prepare(TreeNode root, int start){
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode h = queue.poll();
                if (h.val == start) startNode = h;
                if (h.left != null){
                    parent.put(h.left, h);
                    queue.add(h.left);
                }
                if (h.right != null){
                    parent.put(h.right, h);
                    queue.add(h.right);
                }
            }
        }
    }

    public int infectTime(TreeNode startNode){
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(startNode, 0));
        int maxTime = 0;
        HashSet<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            maxTime = Math.max(maxTime, p.getValue());
            TreeNode n = p.getKey();
            visited.add(n.val);
            if (n.left != null && !visited.contains(n.left.val)) queue.add(new Pair<>(n.left, p.getValue() + 1));
            if (n.right != null && !visited.contains(n.right.val)) queue.add(new Pair<>(n.right, p.getValue() + 1));
            if (parent.containsKey(n) && !visited.contains(parent.get(n).val)) queue.add(new Pair<>(parent.get(n), p.getValue() + 1));
        }

        return maxTime;
    }
}
