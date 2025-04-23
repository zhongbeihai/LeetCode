//package com.binary_tree
//
//import structure.TreeNode
//
//class FindDuplicateSubtrees_652 {
//
//    var map = HashMap<String, Int>()
//    var res = ArrayList<TreeNode>()
//    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
//        dfs(root)
//
//        return res
//    }
//
//    fun dfs(root: TreeNode?): String{
//        if(root == null) return ""
//
//        val key = StringBuffer().append(root.`val`).append(",").append(dfs(root.left)).append(",").append(dfs(root.right)).toString()
//        map.put(key, map.getOrDefault(key, 0) + 1)
//        if(map.getOrDefault(key,0)!! == 2) res.add(root)
//        return key
//    }
//}