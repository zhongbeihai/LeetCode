package com.dynamic_programming

class DecodeWay_91 {
    fun numDecodings(s: String): Int {
        if(s.isEmpty() || s[0] == '0') return 0

        val dp = Array(s.length + 1) { 0 }
        dp[0] = 1
        for (i in 1 until dp.size step 1){
            if(s[i - 1] != '0'){
                dp[i] = dp[i - 1]
            }else{
                dp[i] = 0
            }

            if(i >= 2 && s.substring(i - 2, i).toInt() in 1 .. 26 && s[i - 2] != '0'){
                dp[i] += dp[i - 2]
            }
        }

        return dp[s.length]
    }

}

fun main(){
    val d = DecodeWay_91()
    d.numDecodings("2101")
}