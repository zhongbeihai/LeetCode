package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CreateBinaryTreeFronDescriptions_2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<TreeNode, TreeNode> rela = new HashMap<>();
        for (int[] description: descriptions){
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode = map.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));
            TreeNode childNode = map.computeIfAbsent(childVal, k -> new TreeNode(childVal));

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            rela.put(childNode, parentNode);
        }

        // Find the root node
        TreeNode root = null;
        for (TreeNode node : map.values()) {
            if (!rela.containsKey(node)) {
                root = node;
                break;
            }
        }
        return root;
    }

}
