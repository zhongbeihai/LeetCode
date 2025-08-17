package com.binary_tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder_105 {
    int[] preorder, inorder;
    int preorderIdx = 0;
     // map val to index in inorder
    Map<Integer, Integer> inorderValToIdx = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++){
            inorderValToIdx.put(inorder[i], i);
        }

        int n = preorder.length;
        return build(0,  n - 1);
    }

    /**
     *
     * @param inL the left bound of current subtree in inorder array
     * @param inR the right bound of current subtree in inorder array
     * @return
     */
    public TreeNode build(int inL, int inR){
        // stop condition
        if (inL > inR) return null;

        int val = preorder[preorderIdx++];
        int idx = inorderValToIdx.get(val);

        TreeNode root = new TreeNode(val);
        root.left = build(inL, idx - 1);
        root.right = build(idx + 1, inR);

        return root;
    }
}
