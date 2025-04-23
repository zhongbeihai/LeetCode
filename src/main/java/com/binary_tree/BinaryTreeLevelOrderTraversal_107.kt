package com.binary_tree

import structure.TreeNode
import java.util.Collections
import java.util.Stack

class BinaryTreeLevelOrderTraversal_107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
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

        res.reverse()
        return res
    }

}