package com.binary_tree

import structure.TreeNode

class LongestUnivaluePath_687 {

    var max = 0
    fun longestUnivaluePath(root: TreeNode?): Int{
        traverse(root)
        return max
    }

    fun traverse(root: TreeNode?): Int{
        // stop
        if(root == null) return 0

        val left = traverse(root.left)
        val right = traverse(root.right)

        val toLeft = if(root.left != null && root.left.`val` == root.`val`) left + 1 else 0
        val toRight = if(root.right != null && root.right.`val` == root.`val`) right + 1 else 0

        max = maxOf(max, toLeft + toRight)
        return maxOf(toLeft, toRight)
    }
}