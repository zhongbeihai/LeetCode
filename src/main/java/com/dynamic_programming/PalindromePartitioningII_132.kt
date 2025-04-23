package com.dynamic_programming

import kotlin.math.min

class PalindromePartitioningII_132 {
    fun minCut(s: String): Int {
       if(s.isEmpty()) return 0
       val dp = IntArray(s.length)

       for(i in s.indices){
           dp[i] = i
           for(j in 0 until i + 1){
               val sb = s.substring(j, i+1)
               if(isPalindrome(sb)){
                   if(j == 0){
                       dp[i] = 0
                   }else{
                       dp[i] = min(dp[i], dp[j - 1] + 1)
                   }
               }
           }
       }

        return dp[s.length - 1]
    }


    fun isPalindrome(s:String): Boolean{
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}

fun main(){
    val p = PalindromePartitioningII_132()
    p.minCut("aab")
}