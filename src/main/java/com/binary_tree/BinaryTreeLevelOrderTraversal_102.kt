package com.binary_tree

import structure.TreeNode

class BinaryTreeLevelOrderTraversal_102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        val q = ArrayDeque<TreeNode>()

        if (root == null) return res
        q.addLast(root)

        while (!q.isEmpty()){
            var levelSize = q.size
            val tem = ArrayList<Int>()
            for(i in 0 until levelSize){
                tem.add(q.first().`val`)
                if(q.first().left != null){
                    q.addLast(q.first().left)
                }
                if(q.first().right != null){
                    q.addLast(q.first().right)
                }
                q.removeFirst()
            }
            res.add(tem)
        }
        return res
    }
}