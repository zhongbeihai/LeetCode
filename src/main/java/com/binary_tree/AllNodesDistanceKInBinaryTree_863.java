package com.binary_tree;

import structure.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentsMap = new HashMap<>();
        buildParentMap(root, null, parentsMap);

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        queue.add(target);
        int step = -1;
        while (!queue.isEmpty()){
            step++;

            if (step == k){
                for (int i = 0; i < queue.size(); i++) res.add(queue.poll().val);
            }else {
                for (int i = 0; i < queue.size(); i++){
                    TreeNode cur = queue.poll();
                    if (cur.left != null && visited.add(cur.left)) queue.add(cur.left);
                    if (cur.right != null && visited.add(cur.right)) queue.add(cur.right);
                    TreeNode parent = parentsMap.get(cur);
                    if (parent != null && visited.add(parent)) queue.add(parent);
                }
            }
        }

        return res;
    }

    private void buildParentMap(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> map){
        if (cur == null) return;
        map.put(cur, parent);

        buildParentMap(cur.left, cur, map);
        buildParentMap(cur.right, cur, map);
    }
}
