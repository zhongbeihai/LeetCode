package com.binary_tree;

import structure.Pair;
import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthOfBinaryTree_662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, int[]>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, new int[]{1, 1}));

        int res = 0;
        int preLevel = 1, preNum = 1;
        while (!queue.isEmpty()){
            Pair<TreeNode, int[]> p = queue.poll();
            TreeNode node = p.getKey();
            int[] nu = p.getValue();

            if (nu[0] > preLevel){
                preLevel = nu[0];
                preNum = nu[1];
            }
            res = Math.max(res, nu[1] - preNum);
            if (node.left != null){
                queue.add(new Pair<>(node.left, new int[]{nu[0] + 1, nu[1] * 2}));
            }
            if (node.right != null){
                queue.add(new Pair<>(node.right, new int[]{nu[0] + 1, nu[1] * 2 + 1}));
            }
        }

        return res;
    }
}
