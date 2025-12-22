package com.binary_tree;

import structure.Pair;
import structure.TreeNode;
import sun.print.PSPrinterJob;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected_2385 {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode startNode = buildParentMap(root, null, map, start);

        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        queue.add(startNode);
        set.add(startNode);
        int res = -1;
        while (!queue.isEmpty()){
            int curQueueSize = queue.size();
            res++;
            for (int i = 0; i < curQueueSize; i++) {
                TreeNode s = queue.poll();
                if (s.left != null && set.add(s.left)) queue.add(s.left);
                if (s.right != null && set.add(s.right)) queue.add(s.right);
                TreeNode pa = map.get(s);
                if ( pa != null && set.add(pa)) queue.add(pa);
            }

        }

        return res;
    }

    // build parent map and return start node
    public TreeNode buildParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map, int start){
        if(root == null) return null;

        map.put(root, parent);
        TreeNode left = buildParentMap(root.left, root, map, start);
        TreeNode right = buildParentMap(root.right, root, map, start);

        if (root.val == start) return root;
        return left != null ? left : right;
    }
}
