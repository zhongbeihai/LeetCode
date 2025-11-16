package com.two_pointers;

public class NumberOfSubstringsWithOnly1s_1513 {
    public int numSub(String s) {
        int n = s.length(), left = -1;
        char[] ss = s.toCharArray();
        int MOD = 1_000_000_007, res = 0;

        for (int right = 0; right < n; right++) {
            if (ss[right] == '1'){
                res += right - left;
                res %= MOD;
            }else{
                left = right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NumberOfSubstringsWithOnly1s_1513 n = new NumberOfSubstringsWithOnly1s_1513();
        n.numSub("101");
    }
}
