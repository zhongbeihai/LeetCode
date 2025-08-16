package com.binary_tree;

import javafx.util.Pair;
import structure.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentGraph(root, null, parentMap);

        List<Integer> res = new ArrayList<>();
        // bfs
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        queue.add(target);
        int step = -1;
        while (!queue.isEmpty()){
            int curQueSize = queue.size();
            step++;
            if (step == k){
                for (int i = 0; i < curQueSize; i++) {
                    res.add(queue.poll().val);
                }
                return res;
            }else {
                for (int i = 0; i < curQueSize; i++) {
                    TreeNode c = queue.poll();
                    if (c.left != null && visited.add(c.left)) queue.add(c.left);
                    if (c.right != null && visited.add(c.right)) queue.add(c.right);
                    TreeNode p = parentMap.get(c);
                    if (p != null && visited.add(p)) queue.add(p);
                }
            }
        }

        return res;
    }

    public void buildParentGraph(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap){
        if (root == null) return;

        parentMap.put(root, parent);
        buildParentGraph(root.left, root, parentMap);
        buildParentGraph(root.right, root, parentMap);
    }
}
