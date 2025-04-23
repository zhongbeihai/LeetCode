package com.binary_tree;

import javafx.util.Pair;
import structure.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree_863 {
    HashMap<TreeNode, TreeNode> parent = new HashMap();
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        bfs(target, k);
        return res;
    }

    public void bfs(TreeNode target, int k) {
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(target, 0));
        Set<TreeNode> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> cur = q.poll();
            TreeNode node = cur.getKey();
            if(visited.contains(node)) continue;
            visited.add(node);
            int cnt = cur.getValue();

            if(cur.getValue() == k) res.add(node.val);
            if(node.left != null) q.add(new Pair<>(node.left, cnt + 1));
            if(node.right != null) q.add(new Pair<>(node.right, cnt + 1));
            if(parent.get(node) != null) q.add(new Pair<>(parent.get(node), cnt + 1));

        }
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null) {
            parent.put( root.left, root);
        }
        if(root.right != null) {
            parent.put(root.right, root);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
