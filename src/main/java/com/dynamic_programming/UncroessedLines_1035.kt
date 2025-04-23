//package com.dynamic_programming
//
//import kotlin.math.max
//
//class UncroessedLines_1035 {
//    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
//        val size1 = nums1.size
//        val size2 = nums2.size
//        val dp = Array(size1 + 1) { Array(size2 + 1) { 0 } }
//        for(i in 1 until size1 + 1){
//            for (j in 1 until size2 + 1){
//                val n = nums1[i - 1]
//                val m = nums2[j - 1]
//                if(nums1[i - 1] == nums2[j - 1]){
//                    dp[i][j] = dp[i - 1][j - 1] + 1
//                }else{
//                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
//                }
//            }
//        }
//
//        return dp[size1][size2]
//    }
//}
//
//fun main(){
//    val u = UncroessedLines_1035()
//    u.maxUncrossedLines(intArrayOf(1,4,2), intArrayOf(1,2,4))
//}