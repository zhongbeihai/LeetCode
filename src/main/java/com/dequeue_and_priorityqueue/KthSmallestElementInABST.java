package com.dequeue_and_priorityqueue;

import structure.TreeNode;

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int cnt = 0;
        while(!stack.isEmpty() || curr != null) {
            while (curr != null ){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            cnt++;
            if(cnt == k) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
